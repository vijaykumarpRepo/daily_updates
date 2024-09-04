package com.hexaexplorers.Daily_updates.Services;

import com.hexaexplorers.Daily_updates.Entity.Info;
import com.hexaexplorers.Daily_updates.Repo.MainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InfoService {

    @Autowired
    MainRepo mainRepo;
    public  List<Info>getAllInfo(){

        ArrayList<Info>getAllInfoList=new ArrayList<>();
        mainRepo.findAll().forEach(info -> getAllInfoList.add(info));
        return  getAllInfoList;
    }
    public String getId(Long id){
        return  mainRepo.findById(id).get().toString();
    }
    public  Info getItemById(Long id)
    {

        return  mainRepo.findById(id).get();
    }

    public boolean updateStatus(Long id){
        Info info=getItemById(id);
        info.setStatus("Completed");
        return saveOrUpdateInfo(info);
    }

    public boolean saveOrUpdateInfo(Info info)
    {
        Info updateObj=mainRepo.save(info);

        if (getItemById(updateObj.getId()) != null){
            return true;
    }
        return false;
    }

    public boolean deleteInto(Long id){
        mainRepo.deleteById(id);
        if (getItemById(id) == null){
            return true;
        }
        return false;
    }


}
