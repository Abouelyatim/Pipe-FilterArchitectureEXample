public  class FilterB extends Filter {
 
    Pipe _dataINPipe;
    Pipe _dataOUTPipe;
    
    public FilterB(Pipe _dataINPipe, Pipe _dataOUTPipe) {
		super();
		this._dataINPipe = _dataINPipe;
		this._dataOUTPipe = _dataOUTPipe;
	}
    public String getData(){
        return _dataINPipe.dataOUT();
    }
     
    public void sendData( String tempData){
        _dataOUTPipe.dataIN(tempData);
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		execute();
	}
	@Override
	synchronized void execute() {
		// TODO Auto-generated method stub

		double op1 = Double.parseDouble(_dataINPipe.dataOUT().trim());
		double op2 = Double.parseDouble(_dataINPipe.dataOUT().trim());
		String operation = _dataINPipe.dataOUT().trim();
		double resultat=0;
		switch(operation){

			case "+":
				resultat = op1+op2;
				break;
			case "-":
				resultat = op1-op2;
				break;
			case "/":
				resultat = op1/op2;
				break;
			case "*":
				resultat = op1*op2;
				break;

			default:
				resultat = 0;

		}


		System.out.println("data out : "+op1+"  " +
				"op2: "+op2+"" +
				"operation: "+operation
		+"Resultats finale : "+resultat);




		//get iNPUT dATA AND add to them a mesage to now that it this
		// executemethod which was executed(of filterB)
		//_dataOUTPipe.dataIN("("+op1+" "+op2+" "+"operation: "+operation+" )"+"--> Filter B "+resultat);
		_dataOUTPipe.dataIN("("+op1+" "+op2+" "+"operation: "+operation+" )"+"--> Filter B "+resultat);
		_dataOUTPipe.dataIN(Double.toString(resultat));


	}
}
 