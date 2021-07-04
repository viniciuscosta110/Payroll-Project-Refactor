package Classes;

import java.util.LinkedList;

public class TimeCard {
	protected int arrive_time;
	protected int departure_time;
	protected int worked_day_time;
	protected int worked_week_time;
	protected String date;

	public void setArrive_time(int arrive_time) {
		this.arrive_time = arrive_time;
	}

	public int getArrive_time() {
		return arrive_time;
	}

	public void setDeparture_time(int departure_time) {
		this.departure_time = departure_time;
	}

	public int getDeparture_time() {
		return departure_time;
	}

	public void setWorked_day_time(int worked_day_time) {
		this.worked_day_time = worked_day_time;
	}

	public int getWorked_day_time() {
		return worked_day_time;
	}

	public void setWorked_week_time(LinkedList<TimeCard> timeCards) {
		int worked_week_time = 0;
		int i = 0;

		for (TimeCard timeCard : timeCards) {
			worked_week_time += timeCard.worked_day_time;
			i++;

			if(i >= 7)
			{
				break;
			}
		}

		this.worked_week_time = worked_week_time;

		System.out.println("Horas trabalhadas nessa semana: " + worked_day_time);
	}

	public int getWorked_week_time() {
		return worked_week_time;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getData() {
		return date;
	}

	public TimeCard()
  {
      
  }
}
