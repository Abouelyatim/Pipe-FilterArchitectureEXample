import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
		while (true){
			String trace  = _dataINPipe.dataOUT();
			double result =Double.parseDouble( _dataINPipe.dataOUT()) ;

			Platform.runLater(()->{
				StartUpTest.resultatLabel.setText(String.valueOf(result));
			});

			StartUpTest.traceBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					StartUpTest.traceLabel.setText(trace);

				}
			});


		}

	}
}
 