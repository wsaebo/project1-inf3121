//William Sæbø klasse 1AB, s 163489

    import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;

	public class MeterologiVindu extends JFrame implements ActionListener
	{

	  private JTextField input;
	  private JTextField inputTall;
	  private JButton knapp;
	  private JTextArea omrade;

	  public MeterologiVindu()
	  {
		super( "Metdata" );



		JLabel ledetekst = new JLabel( "Navn på måned " );
		 JLabel dager= new JLabel( "Antall dager " );
	   input = new JTextField( 10 );
		inputTall = new JTextField(5);
		omrade = new JTextArea(10,40);

		 knapp   = new JButton( "Start" );
		knapp.addActionListener( this );
		JScrollPane scroll = new JScrollPane(omrade);
		Container c = getContentPane();
		c.setLayout( new FlowLayout() );
		c.add( knapp );
		c.add( ledetekst );
		c.add(input );
		c.add( dager );
		c.add(inputTall);
		c.add(scroll);
        omrade.setEditable(false);
		setSize(450,500);
		setVisible(true);
	  }


	  public void actionPerformed( ActionEvent e )
	  {

	   int dag = Integer.parseInt(inputTall.getText());
		String mnd = input.getText();




		if (sjekkGyldigverdi(dag, mnd))
		{

		Meteorologidata d = new Meteorologidata(mnd, dag);

	   String a= d.manedsstatistikk();
		omrade.append (a);

	}

	  }
	//Denne metoden sjekker om inntastede verdier er gyldige, programmet får ikke starte om de er false.
	public boolean sjekkGyldigverdi (int dag1, String mnd1)
	{
	 String [] maned = {"Januar", "Februar", "Mars", "April", "Mai","Juni","Juli","August","September","Oktober","November","Desember"};
	 int antDager =0;
	 int mndNr=0;
	 for (int i=0;i<maned.length;i++)
	{

	  if(mnd1.equalsIgnoreCase(maned[i]))
	   {
		  mndNr=i+1;
	   }
	 }
		 switch(mndNr)
			 {
			 case 4:
			 case 6:
			 case 9:
			 case 11: antDager=30; break;
			 case 2: antDager=28; break;
			 default: antDager=31; break;

		 }
	return dag1<=antDager&&dag1>0;


	}


	}
