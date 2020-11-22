package com.rep.filepath.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclEntryType;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;

public class AclFileAttr {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\nio\\FileOwnerAttrView.java");
        AclFileAttributeView fileAttributeView = Files.getFileAttributeView(path, AclFileAttributeView.class);
        List<AclEntry> aclEntryList = fileAttributeView.getAcl();

        for (AclEntry aclEntry : aclEntryList) {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(aclEntry.principal().getName());
            System.out.println(aclEntry.type().toString());
            System.out.println(aclEntry.permissions().toString());
            System.out.println(aclEntry.flags().toString());
        }

        // 重新设置添加acl访问控制设置
        try {
            //Lookup for the principal
            UserPrincipal user = path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("");
//Get the ACL view
            AclFileAttributeView view = Files.getFileAttributeView(path,
                    AclFileAttributeView.class);

            //Create a new entry
            AclEntry entry = AclEntry.newBuilder().setType(AclEntryType.ALLOW).
                    setPrincipal(user).setPermissions(AclEntryPermission.READ_DATA,
                    AclEntryPermission.APPEND_DATA).build();

            //read ACL
            List acl = view.getAcl();

            //Insert the new entry
            acl.add(0, entry);

            //rewrite ACL
            view.setAcl(acl);
            //or, like this
            //Files.setAttribute(path, "acl:acl", acl, NOFOLLOW_LINKS);

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
