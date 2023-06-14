package customsorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeBySal implements Comparator <Employee>
{

	

	@Override
	public int compare(Employee x, Employee y) {
		return x.getSal().compareTo(y.getSal());
	}

}
