package Classes;

public class EmployeeCreator {
	public static Salaried createSalaried(String name, String address, int uniqueID, int paymentSchedule, String paymentType, String paymentWay, Double monthSalary, Double commission) {
		return  new Salaried(name, address, uniqueID, paymentSchedule, paymentType, paymentWay, monthSalary, commission);
	}

	public static Hourly createHourly(String name, String address, int uniqueID, int paymentSchedule, String paymentType, String paymentWay, Double hourSalary) {
		return new Hourly(name, address, uniqueID, paymentSchedule, paymentType, paymentWay, hourSalary);
	}
}
