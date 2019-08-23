package model;

public class Person {
	
	private String name;
	private float amountToTake = 0;
	private float amountToGive = 0;
	private float oweBiswash = 0;
	private float owePrashant = 0;
	private float oweSuman = 0;
	private float oweDipesh = 0;
	private boolean isIncluded;
	
	public boolean isIncluded() {
		return isIncluded;
	}
	public void setIncluded(boolean isIncluded) {
		this.isIncluded = isIncluded;
	}
	public float getOweBiswash() {
		return oweBiswash;
	}
	public void setOweBiswash(float oweBiswash) {
		this.oweBiswash = oweBiswash;
	}
	public float getOwePrashant() {
		return owePrashant;
	}
	public void setOwePrashant(float owePrashant) {
		this.owePrashant = owePrashant;
	}
	public float getOweSuman() {
		return oweSuman;
	}
	public void setOweSuman(float oweSuman) {
		this.oweSuman = oweSuman;
	}
	public float getOweDipesh() {
		return oweDipesh;
	}
	public void setOweDipesh(float oweDipesh) {
		this.oweDipesh = oweDipesh;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getAmountToTake() {
		return amountToTake;
	}
	public void setAmountToTake(int amountToTake) {
		this.amountToTake = amountToTake;
	}
	public float getAmountToGive() {
		return amountToGive;
	}
	public void setAmountToGive(int amountToGive) {
		this.amountToGive = amountToGive;
	}

}
