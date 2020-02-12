package com.example.taxBoisson.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TaxeBoisson  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int annee;
	private int trim;
	private double montantBase;
	private double montantRetard;
	private int moisRetard;
	private double montantTotale;
	@ManyToOne
	private Locale locale;
	@ManyToOne
	private Redevable redevable;
	private double profit;
	@ManyToOne
	private TauxTaxeBoisson tauxTaxeBoisson;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public int getTrim() {
		return trim;
	}
	public void setTrim(int trim) {
		this.trim = trim;
	}
	public double getMontantBase() {
		return montantBase;
	}
	public void setMontantBase(double montantBase) {
		this.montantBase = montantBase;
	}
	public double getMontantRetard() {
		return montantRetard;
	}
	public void setMontantRetard(double montantRetard) {
		this.montantRetard = montantRetard;
	}
	public int getMoisRetard() {
		return moisRetard;
	}
	public void setMoisRetard(int moisRetard) {
		this.moisRetard = moisRetard;
	}
	public double getMontantTotale() {
		return montantTotale;
	}
	public void setMontantTotale(double montantTotale) {
		this.montantTotale = montantTotale;
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public Redevable getRedevable() {
		return redevable;
	}
	public void setRedevable(Redevable redevable) {
		this.redevable = redevable;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public TauxTaxeBoisson getTauxTaxeBoisson() {
		return tauxTaxeBoisson;
	}
	public void setTauxTaxeBoisson(TauxTaxeBoisson tauxTaxeBoisson) {
		this.tauxTaxeBoisson = tauxTaxeBoisson;
	}
	public TaxeBoisson() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TaxeBoisson(Long id, int annee, int trim, double montantBase, double montantRetard, int moisRetard,
			double montantTotale, Locale locale, Redevable redevable, double profit, TauxTaxeBoisson tauxTaxeBoisson) {
		super();
		this.id = id;
		this.annee = annee;
		this.trim = trim;
		this.montantBase = montantBase;
		this.montantRetard = montantRetard;
		this.moisRetard = moisRetard;
		this.montantTotale = montantTotale;
		this.locale = locale;
		this.redevable = redevable;
		this.profit = profit;
		this.tauxTaxeBoisson = tauxTaxeBoisson;
	}
	@Override
	public String toString() {
		return "TaxeBoisson [id=" + id + ", annee=" + annee + ", trim=" + trim + ", montantBase=" + montantBase
				+ ", montantRetard=" + montantRetard + ", moisRetard=" + moisRetard + ", montantTotale=" + montantTotale
				+ ", locale=" + locale + ", redevable=" + redevable + ", profit=" + profit + ", tauxTaxeBoisson="
				+ tauxTaxeBoisson + "]";
	}
	
	
	
	
	
}
