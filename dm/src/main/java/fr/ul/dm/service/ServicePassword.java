package fr.ul.dm.service;

import fr.ul.dm.model.*;
import fr.ul.dm.repository.RepositoryPassword;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


@Service
public class ServicePassword {

    @Autowired
    private RepositoryPassword repositoryPassword;


    public void savePassword(String password){
        Password psw = new Password(password,null);

        repositoryPassword.save(psw);
    }
    public void savePasswordSel(PasswordDTO dto){
        Password psw = new Password(dto.getPassword(),dto.getSel());

        repositoryPassword.save(psw);
    }

    public Iterable<Password> itPass(){
        return repositoryPassword.findAll();
    }
}
