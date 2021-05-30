package template.Application.controller;

import java.sql.Date;

public class Mypage_reservation_data {

	int reservation_id;
	int reservation_number;
	Date reservation_date;
	String seat_number;
	int car_type;
	int payment_price;
	Date payment_date;
	String option_name;
	int option_price;
	int member_id;
	int movie_id;

	@Override
	public String toString() {
		return "Mypage_reservation_data [reservation_id=" + reservation_id + ", reservation_number="
				+ reservation_number + ", reservation_date=" + reservation_date + ", seat_number=" + seat_number
				+ ", car_type=" + car_type + ", payment_price=" + payment_price + ", payment_date=" + payment_date
				+ ", option_name=" + option_name + ", option_price=" + option_price + ", member_id=" + member_id
				+ ", movie_id=" + movie_id + "]";
	}

	public Mypage_reservation_data() {
	}

	public Mypage_reservation_data(int reservation_id, int reservation_number, Date reservation_date,
			String seat_number, int car_type, int payment_price, Date payment_date, String option_name,
			int option_price, int member_id, int movie_id) {
		super();
		this.reservation_id = reservation_id;
		this.reservation_number = reservation_number;
		this.reservation_date = reservation_date;
		this.seat_number = seat_number;
		this.car_type = car_type;
		this.payment_price = payment_price;
		this.payment_date = payment_date;
		this.option_name = option_name;
		this.option_price = option_price;
		this.member_id = member_id;
		this.movie_id = movie_id;
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}

	public int getReservation_number() {
		return reservation_number;
	}

	public void setReservation_number(int reservation_number) {
		this.reservation_number = reservation_number;
	}

	public Date getReservation_date() {
		return reservation_date;
	}

	public void setReservation_date(Date reservation_date) {
		this.reservation_date = reservation_date;
	}

	public String getSeat_number() {
		return seat_number;
	}

	public void setSeat_number(String seat_number) {
		this.seat_number = seat_number;
	}

	public int getCar_type() {
		return car_type;
	}

	public void setCar_type(int car_type) {
		this.car_type = car_type;
	}

	public int getPayment_price() {
		return payment_price;
	}

	public void setPayment_price(int payment_price) {
		this.payment_price = payment_price;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public String getOption_name() {
		return option_name;
	}

	public void setOption_name(String option_name) {
		this.option_name = option_name;
	}

	public int getOption_price() {
		return option_price;
	}

	public void setOption_price(int option_price) {
		this.option_price = option_price;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

}
