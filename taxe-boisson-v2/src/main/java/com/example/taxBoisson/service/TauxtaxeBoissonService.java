package com.example.taxBoisson.service;

import java.util.List;

import com.example.taxBoisson.bean.Categorie;
import com.example.taxBoisson.bean.TauxTaxeBoisson;

public interface TauxtaxeBoissonService {
public int save(TauxTaxeBoisson taxe);
public TauxTaxeBoisson findByCategorieLibelle(String libelle) ;
public List<TauxTaxeBoisson>findAll();
public int deleteByCategorieLibelle(String libelle);
public TauxTaxeBoisson tauxlocal(String local);


public int modify(String libelle, int tauxnormel,int tauxretard);
}
