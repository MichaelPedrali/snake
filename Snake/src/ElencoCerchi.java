import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class ElencoCerchi {
 private Cerchio elC[];
 
 public ElencoCerchi(){
	 elC = new Cerchio[0];
 }
 
	
	public boolean aggiungi(Cerchio c){	
			elC = Arrays.copyOf(elC,elC.length+1);
			elC[elC.length-1] = new Cerchio(c);
			return true;
		}
	


	
	public boolean elimina(Cerchio c){
		for(int i=0;i<elC.length;i++){
			if(elC[i].equals(c)){
				elC[i] = elC[elC.length-1];
				elC = Arrays.copyOf(elC,elC.length-1);
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return Arrays.toString(elC);
	}
	
	public void SalvaSuFile(){
		BufferedWriter scrittore;
		try {
			scrittore = new BufferedWriter(new FileWriter("Record.txt"));
			for(int i=0;i<elC.length;i++){
		     scrittore.write(elC[i].toString());
		     scrittore.newLine();
			}
		scrittore.close();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	
	public void LeggiSuFile(){
		BufferedReader lettore;
		String riga = " ";
		String v[];
		int i=0;
		try{
			lettore = new BufferedReader(new FileReader("Record.txt"));
			do{
				riga = lettore.readLine();
				if(riga != null){

				}
			}while(riga != null);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	

}


