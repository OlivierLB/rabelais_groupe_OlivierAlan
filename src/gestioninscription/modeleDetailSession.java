/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioninscription;

/**
 *
 * @author Administrateur
 */
import javax.swing.table.AbstractTableModel;

public class  modeleDetailSession extends AbstractTableModel
{
	private String[] columnNames = {"Maticule du client", "Nom", "Numero de la formation", "Libelle", "Niveau", "Date de début", "Date d'inscription", "Taux horaire"};
	private Object[][] data=new Object[10][8];
	public int getColumnCount()
	{
		return columnNames.length;
	}
	public int getRowCount()
	{
		return data.length;
	}
	public String getColumnName(int col)
	{
		return columnNames[col];
	}
	public Object getValueAt(int row, int col)
	{
		return data[row][col];
	}
	
	public boolean isCellEditable(int row, int col)
	{
		return (col < 2);
	}
	public void setValueAt(Object value, int row, int col)
	{
		data[row][col] = value;
		fireTableCellUpdated(row,col);
		//fireTableDataChanged();
	}
}