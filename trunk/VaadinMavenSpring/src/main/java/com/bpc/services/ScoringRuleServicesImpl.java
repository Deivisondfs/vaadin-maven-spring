package com.bpc.services;

import com.bpc.dao.MappingRuleDao;
import com.bpc.dao.ScoringRuleCaseDao;
import com.bpc.dao.ScoringRuleDao;
import com.bpc.model.MappingRule;
import com.bpc.model.ScoringRule;
import com.bpc.model.ScoringRuleCase;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/18/11
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class ScoringRuleServicesImpl implements ScoringRuleServices {
    private ScoringRuleDao scoringRuleDao;
    private ScoringRuleCaseDao scoringRuleCaseDao;
    private MappingRuleDao mappingRuleDao;

    public void setScoringRuleDao(ScoringRuleDao scoringRuleDao) {
        this.scoringRuleDao = scoringRuleDao;
    }

    public void setScoringRuleCaseDao(ScoringRuleCaseDao scoringRuleCaseDao) {
        this.scoringRuleCaseDao = scoringRuleCaseDao;
    }

    public void setMappingRuleDao(MappingRuleDao mappingRuleDao) {
        this.mappingRuleDao = mappingRuleDao;
    }

    public List<ScoringRule> getAll() {
        return this.scoringRuleDao.getList();
    }

    public List<ScoringRuleCase> getRuleCaseList(ScoringRule scoringRule) {
        return scoringRuleCaseDao.getRuleCaseList(scoringRule);
    }

    public List<MappingRule>  getMappingRuleList(ScoringRule scoringRule){
        return mappingRuleDao.getMappingRuleList(scoringRule);
    }

}