package com.example.taxBoisson.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class TaxeBoisson  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int annee;
	private int trim;
	private double montantBase;
	private double montantRetard;
	private double  moisRetard;
	private double montantTotale;
	@ManyToOne
	private Locale locale; 
	@ManyToOne
	private Redevable redevable;
	private double profit;
	@ManyToOne
	private TauxTaxeBoisson tauxTaxeBoisson;
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-YYYY")
	private Date datePresentation;
	public Date getDatePresentation() {
		return datePresentation;
	}
	public void setDatePresentation(Date datePresentation) {
		this.datePresentation = datePresentation;
	}
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
	public double getMoisRetard() {
		return moisRetard;
	}
	public void setMoisRetard(double moisRetard) {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annee;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = (int) (prime * result + moisRetard);
		long temp;
		temp = Double.doubleToLongBits(montantBase);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(montantRetard);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(montantTotale);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(profit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((redevable == null) ? 0 : redevable.hashCode());
		result = prime * result + ((tauxTaxeBoisson == null) ? 0 : tauxTaxeBoisson.hashCode());
		result = prime * result + trim;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaxeBoisson other = (TaxeBoisson) obj;
		if (annee != other.annee)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (moisRetard != other.moisRetard)
			return false;
		if (Double.doubleToLongBits(montantBase) != Double.doubleToLongBits(other.montantBase))
			return false;
		if (Double.doubleToLongBits(montantRetard) != Double.doubleToLongBits(other.montantRetard))
			return false;
		if (Double.doubleToLongBits(montantTotale) != Double.doubleToLongBits(other.montantTotale))
			return false;
		if (Double.doubleToLongBits(profit) != Double.doubleToLongBits(other.profit))
			return false;
		if (redevable == null) {
			if (other.redevable != null)
				return false;
		} else if (!redevable.equals(other.redevable))
			return false;
		if (tauxTaxeBoisson == null) {
			if (other.tauxTaxeBoisson != null)
				return false;
		} else if (!tauxTaxeBoisson.equals(other.tauxTaxeBoisson))
			return false;
		if (trim != other.trim)
			return false;
		return true;
	}
	
	
	
	
	
}
