package Classes;

import java.util.LinkedList;

public class TimeCard {
	protected int arrive_time;
	protected int departure_time;
	protected int worked_day_time;
	protected int worked_week_time;
	protected Double exceeded_time = 0.0;
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
			if(timeCard.worked_day_time > 8)
			{
				worked_week_time += 8;
				setExceeded_time(timeCard.worked_day_time % 8.0);
			}
			else
			{
				worked_week_time += timeCard.worked_day_time;
			}
			
			i++;

			if(i >= 7)
			{
				break;
			}
		}

		this.worked_week_time = worked_week_time;

		System.out.println("Horas trabalhadas nessa semana: " + worked_day_time + "\n");
	}

	public int getWorked_week_time() {
		return worked_week_time;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public Double getExceeded_time() {
		return exceeded_time;
	}

	public void setExceeded_time(Double exceeded_time) {
		this.exceeded_time = this.exceeded_time + exceeded_time;
	}

	public TimeCard(int arrive_time, int departure_time, String date)
	{
		this.arrive_time = arrive_time;
		this.departure_time = departure_time;
		this.date = date;
	}

	public TimeCard()
	{

	}
}
