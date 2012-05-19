package com.company.travel.controller;

import com.company.travel.entity.CompanyAccount;
import com.company.travel.entity.CompanyInfo;
import com.company.travel.service.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Route Action 类，包含对于所有 Route 对象的操作
 *
 * @author 胡荆陵
 */
@Controller
@Scope("prototype")
public class CompanyInfoAction extends BasePagerAction {

    private CompanyInfo companyInfo;
    private List<CompanyAccount> companyAccountList;

    @Resource
    private CompanyInfoService companyInfoService;
    @Resource
    private CompanyAccountService companyAccountService;

    //getter & setter
    public List<CompanyAccount> getCompanyAccountList() {
        return companyAccountList;
    }

    public void setCompanyAccountList(List<CompanyAccount> companyAccountList) {
        this.companyAccountList = companyAccountList;
    }

    public CompanyAccountService getCompanyAccountService() {
        return companyAccountService;
    }

    public void setCompanyAccountService(CompanyAccountService companyAccountService) {
        this.companyAccountService = companyAccountService;
    }

    public CompanyInfoService getCompanyInfoService() {
        return companyInfoService;
    }

    public void setCompanyInfoService(CompanyInfoService companyInfoService) {
        this.companyInfoService = companyInfoService;
    }

    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
    }

    public String blank() {
        return SUCCESS;
    }

    public String create() {
        companyInfoService.save(companyInfo);
        if (companyAccountList != null && companyAccountList.size() > 0) {
            for (int i = 0; i < companyAccountList.size(); i++) {
                CompanyAccount companyAccount = companyAccountList.get(i);
                companyAccount.setCompanyID(companyInfo.getId());
                companyAccount.setSeq(String.valueOf(i + 1));
                companyAccountService.save(companyAccount);
            }
        }
        return SUCCESS;
    }

    public String view() {
        companyInfo = new CompanyInfo();
        companyAccountList = new ArrayList<CompanyAccount>();
        List<CompanyInfo> companyInfoList = companyInfoService.getAll();
        if (companyInfoList != null && companyInfoList.size() > 0) {
            companyInfo = companyInfoList.get(0);
            for (CompanyAccount companyAccount : companyInfoList.get(0).getCompanyAccountList()) {
                companyAccountList.add(companyAccount);
            }
        }
        return SUCCESS;
    }

    public String initCreateOrUpdate() {
        List<CompanyInfo> companyInfoList = companyInfoService.getAll();
        if (companyInfoList != null && companyInfoList.size() > 0) {
            companyAccountList = new ArrayList<CompanyAccount>();
            companyInfo = companyInfoList.get(0);
            for (CompanyAccount companyAccount : companyInfoList.get(0).getCompanyAccountList()) {
                companyAccountList.add(companyAccount);
            }
        }
        return SUCCESS;
    }

    public String update() {
        // step 1 : delete old values
        List<CompanyAccount> list = companyAccountService.getList("companyID", companyInfo.getId());
        for (CompanyAccount oldValue : list) {
            companyAccountService.delete(oldValue);
        }
        //step 2 : update route
        companyInfoService.update(companyInfo);
        //step 3 : save new journey
        if (companyAccountList != null && companyAccountList.size() > 0) {
            for (int i = 0; i < companyAccountList.size(); i++) {
                CompanyAccount companyAccount = companyAccountList.get(i);
                companyAccount.setCompanyID(companyInfo.getId());
                companyAccount.setSeq(String.valueOf(i + 1));
                companyAccountService.save(companyAccount);
            }
        }
        return SUCCESS;
    }
}
