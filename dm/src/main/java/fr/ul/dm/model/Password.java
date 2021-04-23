package fr.ul.dm.model;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


@Entity
public class Password {

    private static String SALT = "salage";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String password;
    private String passwordHashe;
    private String passwordHasheEtSale;
    private String PasswordHasheEtSaleUtilisateur;
    private String passwordChiffre;

    public String getPasswordChiffre() {
        return passwordChiffre;
    }

    public void setPasswordChiffre(String passwordChiffre) {
        this.passwordChiffre = passwordChiffre;
    }

    public String getPasswordHasheEtSaleUtilisateur() {
        return PasswordHasheEtSaleUtilisateur;
    }

    public void setPasswordHasheEtSaleUtilisateur(String passwordHasheEtSaleUtilisateur) {
        PasswordHasheEtSaleUtilisateur = passwordHasheEtSaleUtilisateur;
    }

    public String getPasswordHasheEtSale() {
        return passwordHasheEtSale;
    }

    public void setPasswordHasheEtSale(String passwordHasheEtSale) {
        this.passwordHasheEtSale = passwordHasheEtSale;
    }

    public String getPasswordHashe() {
        return passwordHashe;
    }

    public void setPasswordHashe(String passwordHashe) {
        //MessageDigestPasswordEncoder(String algo)
        //ShaPasswordEncoder
        this.passwordHashe = passwordHashe; ;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Password(){

    }

    @Override
    public String toString() {
        return "Password{" +
                "password='" + password + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Password(String password,String sel) {
        if(sel==null){
            sel = "sel";
        }
        this.password = password;
        this.passwordHashe = this.hash(password);
        this.passwordHasheEtSale = this.hashSale(password);
        this.PasswordHasheEtSaleUtilisateur = this.hashSaleUser(password,sel);
        this.passwordChiffre = this.hashSaleUser(this.chiffreAES(password),sel);
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Long getId() {
        return id;
    }

    /*hash sha512 avec salage */
    public String hashSale(String pwd){
        char[] password = pwd.toCharArray();
        byte[] sel = SALT.getBytes();
        //String Hex =  Hex.encodeHexString(res);

        try{
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            PBEKeySpec spec = new PBEKeySpec(password, sel, 3567, 512);
            SecretKey key = skf.generateSecret(spec);
            byte[] res = key.getEncoded();
            return res.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }
    public String hashSaleUser(String pwd,String salt){
        char[] password = pwd.toCharArray();
        byte[] sel = salt.getBytes();
        //String Hex =  Hex.encodeHexString(res);

        try{
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            PBEKeySpec spec = new PBEKeySpec(password, sel, 3567, 512);
            SecretKey key = skf.generateSecret(spec);
            byte[] res = key.getEncoded();
            return res.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

    public String hash(String pwd){
        byte[] password = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(pwd.getBytes());
            password = md.digest();
            return password.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public String chiffreAES(String psw){
        String chiffr = "AZERTYUIOPQSDFGH";

        SecretKeySpec secretKeySpec = new SecretKeySpec(chiffr.getBytes(),"AES");
        try {
            Cipher chiffreur = Cipher.getInstance("AES");
            chiffreur.init(Cipher.ENCRYPT_MODE,secretKeySpec);
            return chiffreur.doFinal(psw.getBytes()).toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }


}
