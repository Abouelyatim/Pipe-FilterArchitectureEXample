public  class FilterC extends Filter {
 
    Pipe _dataINPipe;
    Pipe _dataOUTPipe;
     
    public FilterC(Pipe _dataINPipe, Pipe _dataOUTPipe) {
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
			String trace  = _dataINPipe.dataOUT();
			double result =Double.parseDouble( _dataINPipe.dataOUT()) ;
			System.out.println("result in filterC: "+result);
		System.out.println("trace in filterC: "+trace);

		_dataOUTPipe.dataIN(result+"--> Filter C");
	}
}
 