package example.exchange;
 
// 화폐 : 화폐 = 환율
public class ExchangeRate {
 
 	// 넣을 화폐 (ex. 원화, 달러, 엔화, ...)
 	private String exchangingCurrency;
 
 	// 바꿀 화폐 (ex. 원화, 달러, 엔화, ...)
 	private String exchangedCurrency;
 
 	// 환율 ( 1000 / 1,316.30 )
 	private double exchangeRate;

 	
 	// -> usingFields, getter setter자동완성 (Alt + shift + s)
	public ExchangeRate(String exchangingCurrency, String exchangedCurrency, double exchangeRate) {
	
		this.exchangingCurrency = exchangingCurrency;
		this.exchangedCurrency = exchangedCurrency;
		this.exchangeRate = exchangeRate;
	}

	public String getExchangingCurrency() {
		return exchangingCurrency;
	}

	public void setExchangingCurrency(String exchangingCurrency) {
		this.exchangingCurrency = exchangingCurrency;
	}

	public String getExchangedCurrency() {
		return exchangedCurrency;
	}

	public void setExchangedCurrency(String exchangedCurrency) {
		this.exchangedCurrency = exchangedCurrency;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	@Override
	public String toString() {
		return "ExchangeRate [exchangingCurrency=" + exchangingCurrency + ", exchangedCurrency=" + exchangedCurrency
				+ ", exchangeRate=" + exchangeRate + "]";
	}
 	
}
 