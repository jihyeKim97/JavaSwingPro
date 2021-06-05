package template.Application.controller.Data;

import java.util.Date;

public class Reservation_data {
	int reservationID;
	int reservationNumber;
	Date reservationDate;
	String seatNumber;
	int carType;
	int paymentPrice;
	Date paymentDate;
	String optionName;
	int optionPrice;
	int memberID;
	int movieID;

	@Override
	public String toString() {
		return "Reservation_data [reservationID=" + reservationID + ", reservationNumber=" + reservationNumber
				+ ", reservationDate=" + reservationDate + ", seatNumber=" + seatNumber + ", carType=" + carType
				+ ", paymentPrice=" + paymentPrice + ", paymentDate=" + paymentDate + ", optionName=" + optionName
				+ ", optionPrice=" + optionPrice + ", memberID=" + memberID + ", movieID=" + movieID + "]";
	}

	public Reservation_data(int reservationID, int reservationNumber, Date reservationDate, String seatNumber,
			int carType, int paymentPrice, Date paymentDate, String optionName, int optionPrice, int memberID,
			int movieID) {
		super();
		this.reservationID = reservationID;
		this.reservationNumber = reservationNumber;
		this.reservationDate = reservationDate;
		this.seatNumber = seatNumber;
		this.carType = carType;
		this.paymentPrice = paymentPrice;
		this.paymentDate = paymentDate;
		this.optionName = optionName;
		this.optionPrice = optionPrice;
		this.memberID = memberID;
		this.movieID = movieID;
	}

	public Reservation_data(String seatNumber, int carType, int paymentPrice, Date paymentDate, String optionName,
			int optionPrice) {
		super();
		this.seatNumber = seatNumber;
		this.carType = carType;
		this.paymentPrice = paymentPrice;
		this.paymentDate = paymentDate;
		this.optionName = optionName;
		this.optionPrice = optionPrice;
	}

	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public int getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getCarType() {
		return carType;
	}

	public void setCarType(int carType) {
		this.carType = carType;
	}

	public int getPaymentPrice() {
		return paymentPrice;
	}

	public void setPaymentPrice(int paymentPrice) {
		this.paymentPrice = paymentPrice;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public int getOptionPrice() {
		return optionPrice;
	}

	public void setOptionPrice(int optionPrice) {
		this.optionPrice = optionPrice;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

}
