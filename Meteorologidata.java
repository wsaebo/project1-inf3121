
//William S�b� klasse 1AB, s163489
import javax.swing.*;
import java.text.DecimalFormat;

//Klasse som representerer meteorologiske data for �n m�ned
public class Meteorologidata
{
  private String manedsNavn;
  private int [] nedbor;
  private int [] maxTemp;
  private int[] minTemp;
  private int antDager;



  /*<N�dvendige datafelter, blant annet arrayer for lagring av
         meteorologiske data.>*/

	public Meteorologidata(String navn, int dager)
	{

		manedsNavn = navn;
		antDager = dager;
		nedbor = new int [antDager];
		maxTemp = new int [antDager];
		minTemp = new int [antDager];




	}
  /*< Konstrukt�r med parametre for m�nedens navn og antall dager.
    Foretar n�dvendig initialisering. >*/

  public void lesInnVaerdata()

  {


	for (int i = 0; i <antDager; i++)
	{
		do
		{
		  nedbor[i] = Integer.parseInt(JOptionPane.showInputDialog("Nedb�r takk for " + " "+(i+1)+ " dag"));
		  maxTemp[i] = Integer.parseInt(JOptionPane.showInputDialog("Max temperatur for "+" " +(i+1)+" dag"));
		  minTemp[i] = Integer.parseInt(JOptionPane.showInputDialog("Minimum temperatur for "+" " +(i+1) + " dag"));
		if(minTemp[i]>maxTemp[i])
		{
			JOptionPane.showMessageDialog(null, "Minimumstemperaturen er st�rre enn maksimumstemperaturen, pr�v igjen");
		}



		}while((nedbor[i]>150&&nedbor[i]<0)||(maxTemp[i]<minTemp[i]));



	}


    /*<Leser inn v�rdata for det antall dager som er bestemt. kan jeg bare se specsene til pcen? ja neat-o
     Sjekker om verdiene kan aksepteres (se ovenfor). Dersom dette
     er tilfelle, lagres verdiene. Ellers skrives det ut passende
     melding til brukeren, og brukeren bes om � skrive inn nye
     verdier.>*/
  }

  public int antRegndager()
  {
  int a=0;
  for(int i = 0; i<nedbor.length;i++)
  {
	  if(nedbor[i]>=10)
	  a++;

  }
 return a;
 /* <Teller opp antall dager som har hatt nedb�r p� 10 mm eller mer
     og returnerer antallet.>*/
  }

  public double snittMaksTemp()
  {
	  boolean dagerMedUnder10 = false;
	  double sum =0;
	  double snitt=0;
 for (int i = 0;i<maxTemp.length;i++)
 {
       if (nedbor[i]<10)
       {
		  dagerMedUnder10=true;

		  sum = sum+maxTemp[i];

	   }

 	}
 	if(dagerMedUnder10==true)
 	{
 	snitt = sum/maxTemp.length;
	return snitt;
    }

  /*  <Finner gjennomsnittlig maksimumstemperatur for dager med mindre enn
     10 mm nedb�r og returnerer gjennomsnittet.
     Returnerer -100.0 i tilfelle det er ingen slike dager.>*/
     return -100.0;
  }

  public int maksTempvar()
  {
   int tempvar =0;
   for (int i = 0; i<antDager;i++)
   {
   if(maxTemp[i]>minTemp[i])
   {
	tempvar = maxTemp[i]-minTemp[i];
   }
   }
   /* < Finner og returnerer den st�rste temperaturvariasjon som har
     forekommet i l�pet av m�neden. >*/

  return tempvar;

  }



  public String manedsstatistikk()
  {


  lesInnVaerdata();
     int ant = antRegndager();
	 double snitt = snittMaksTemp();
	int tempvar =  maksTempvar();
     String formateringsstreng = "0.0";
	  DecimalFormat formateringsobjekt = new DecimalFormat( formateringsstreng );


	  String output = "Dette er meteorlogidata\n Antall dager med over 10 mm \n" + ant +"\n Gjennomsnittstemp\n "+   formateringsobjekt.format(snitt) + "\nTemperaturvariasjon\n "+tempvar;

	  //metoder
	  return output;
    //< Returnerer de data som skal kunne skrives ut ved
    // m�nedens slutt, se ovenfor. (Et av punktene var ikke obligatorisk.)> Her
  }
}
