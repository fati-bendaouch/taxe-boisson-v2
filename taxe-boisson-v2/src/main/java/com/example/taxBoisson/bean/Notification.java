package com.example.taxBoisson.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Notification  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int anneeMin;
	private int anneeMax;

	private int trimMin;
	private int trimMax;

	private double montantBase;
	private double montantRetard;
	private int moisRetard;
	private double montantTotale;
	@ManyToOne
	private Locale locale;
	
	@ManyToOne
	private Redevable redevable;
	private double profit;

	
	
	public int getAnneeMin() {
		return anneeMin;
	}
	public void setAnneeMin(int anneeMin) {
		this.anneeMin = anneeMin;
	}
	public int getAnneeMax() {
		return anneeMax;
	}
	public void setAnneeMax(int anneeMax) {
		this.anneeMax = anneeMax;
	}
	public int getTrimMin() {
		return trimMin;
	}
	public void setTrimMin(int trimMin) {
		this.trimMin = trimMin;
	}
	public int getTrimMax() {
		return trimMax;
	}
	public void setTrimMax(int trimMax) {
		this.trimMax = trimMax;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Notification other = (Notification) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Notification [id=" + id + ", anneeMin=" + anneeMin + ", anneeMax=" + anneeMax + ", trimMin=" + trimMin
				+ ", trimMax=" + trimMax + ", montantBase=" + montantBase + ", montantRetard=" + montantRetard
				+ ", moisRetard=" + moisRetard + ", montantTotale=" + montantTotale + ", locale=" + locale
				+ ", profit=" + profit + "]";
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
