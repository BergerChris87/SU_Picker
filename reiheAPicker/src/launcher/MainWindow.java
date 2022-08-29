package launcher;

import java.io.IOException;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import logic_reiheAPicker.GetButtonPics;
import userInterface_reiheAPicker.ISBNCheckerTab;
import userInterface_reiheAPicker.ImportSettingsTab;
import userInterface_reiheAPicker.LegalInformationScene;
import userInterface_reiheAPicker.PickerTab;

public class MainWindow extends Application{
	
	private Scene reiheAPickerScene = null;
	private Scene isbnCheckerScene = null;
	private Scene viviScene = null;
	private Scene toolChooserScene = null;
	
		public static void startWindow(String[] args)
		{
			launch(args);
		}
	
	   @Override
	    public void start(Stage primaryStage) throws IOException {
	        primaryStage.setTitle(var_reiheAPicker.Constants.ProgramName);
	        	       
	        Image tooltipIcon = GetButtonPics.getButtonImage_TooltipIcon();
	        if (tooltipIcon != null)
	        {  	
	        	primaryStage.getIcons().add(tooltipIcon);
	        }      
	        
	 	   
	        initiateReiheAPicker(primaryStage);
	        primaryStage.show();
	        
	    } 	  
	   
	   private void initiateISBNChecker(Stage primaryStage)
	   {
		   if (this.isbnCheckerScene == null)
		   {
	        ISBNCheckerTab isbnChecker = new ISBNCheckerTab();	        
	        TabPane mainTabPane = new TabPane();	         
	        mainTabPane.getTabs().add(isbnChecker.isbnCheckerTab);

	        
	        VBox vBoxMenu = new VBox(mainTabPane);
	        this.isbnCheckerScene = new Scene(vBoxMenu);
	        
		   } 
		   primaryStage.setScene(this.isbnCheckerScene);
	        	        
	        
	   }
	   
	   private void initiateReiheAPicker(Stage primaryStage) throws IOException
	   {
		  if (this.reiheAPickerScene == null)
		  {
			  Button importButton = new Button();
			  Button legalInformationButton = new Button();
		        ProgressIndicator progressIndicator = new ProgressIndicator(0);
		        Tooltip tooltip = new Tooltip();
		        tooltip.setText("Prüfe Titel auf Bestand und Open-Access-Status. Bitte warten!");
		        progressIndicator.setTooltip(tooltip);
		            
		        
		        
		        Image legalInfoButtonImage = GetButtonPics.getButtonImage_LegalInfo();
		        if (legalInfoButtonImage != null)
		        {  	
			    legalInformationButton.setGraphic(GetButtonPics.turnPicIntoImageView(legalInfoButtonImage));
		        }	
		        Tooltip legalTooltip = new Tooltip();
		        legalTooltip.setText("Impressum und Lizeninformationen");
		        legalInformationButton.setTooltip(legalTooltip);
		       
		        
		        Image importButtonImage = GetButtonPics.getButtonImage_importButton();
		        if (importButtonImage != null)
		        {  	
			    importButton.setGraphic(GetButtonPics.turnPicIntoImageView(importButtonImage));
		        }	 	        
		        Tooltip importTooltip = new Tooltip();
		        importTooltip.setText("Import (CSV/TSV oder PSF-Dateien)");
		        importButton.setTooltip(importTooltip);
		        
		        
		        //Button tutorialButton = new Button();
		        //tutorialButton.setText("Tutorial"); 
		        //Button exportButton = new Button();
		        //exportButton.setText("Export"); 	   
		        
		        Region region = new Region();
				
				HBox.setHgrow(region, Priority.ALWAYS);
		        
		        HBox controlsHBox = new HBox(importButton, region, progressIndicator, legalInformationButton);	 
		        controlsHBox.setMinHeight(35);
		        HBox.setMargin(importButton, new Insets(5,5,5,5));
		        HBox.setMargin(legalInformationButton, new Insets(5,5,5,5));
		        controlsHBox.setAlignment(Pos.CENTER_LEFT);
		        
		         
		        
		        PickerTab pickerTab = new PickerTab(primaryStage);
		        
		        TabPane mainTabPane = new TabPane();	        
		        ImportSettingsTab importSettingsTab = new ImportSettingsTab(primaryStage);	 
		        progressIndicator.setVisible(false);
		        
		        legalInformationButton.setOnAction(new EventHandler<ActionEvent>() {
		            @Override public void handle(ActionEvent e) {
		            	openLegalInformationScene();
		            }
		        });  	
		        
		        importButton.setOnAction(new EventHandler<ActionEvent>() {
		            @Override public void handle(ActionEvent e) {
		                try {
		                	
		                	
		                	if (mainTabPane.getTabs().contains(pickerTab.pickerTab))
		                	{
		                		Alert alert = 
		                		        new Alert(AlertType.WARNING, 
		                		            "Daten erneut importieren? Aktueller Fortschritt geht verloren!",
		                		             ButtonType.OK, 
		                		             ButtonType.CANCEL);
		                		alert.setTitle("Aktuellen Fortschritt überschreiben?");
		                		Optional<ButtonType> result = alert.showAndWait();

		                		if (result.get() == ButtonType.OK) {
		                			mainTabPane.getTabs().remove(pickerTab.pickerTab);
		                			importSettingsTab.openFileAndLoad();
		                			if (importSettingsTab.isSaveFileLoad)
			                		{
			                			pickerTab.rebuild(importSettingsTab.ColumnNamesFromSaveFile,
			                					importSettingsTab.nopeTitlesFromSaveFile,
			                					importSettingsTab.queueTitlesFromSaveFile,
			                					importSettingsTab.pickTitlesFromSaveFile);
			                			mainTabPane.getTabs().add(pickerTab.pickerTab);	
										setPickerTabActive(mainTabPane, pickerTab);	
			                		} else
			                		{
			                			pickerTab.rebuild(importSettingsTab.titles, progressIndicator);
										mainTabPane.getTabs().add(pickerTab.pickerTab);	
										setPickerTabActive(mainTabPane, pickerTab);	
			                		}
		    						mainTabPane.getSelectionModel().select(mainTabPane.getTabs().indexOf(pickerTab.pickerTab));
		                		}
		                	}   
		                	else
		                	{
		                		importSettingsTab.openFileAndLoad();
		                		if (importSettingsTab.isSaveFileLoad)
		                		{
		                			pickerTab.rebuild(importSettingsTab.ColumnNamesFromSaveFile,
		                					importSettingsTab.nopeTitlesFromSaveFile,
		                					importSettingsTab.queueTitlesFromSaveFile,
		                					importSettingsTab.pickTitlesFromSaveFile);
		                			mainTabPane.getTabs().add(pickerTab.pickerTab);	
									setPickerTabActive(mainTabPane, pickerTab);	
		                		} else
		                		{
		                			pickerTab.rebuild(importSettingsTab.titles, progressIndicator);
									mainTabPane.getTabs().add(pickerTab.pickerTab);	
									setPickerTabActive(mainTabPane, pickerTab);	
		                		}
		                		mainTabPane.getSelectionModel().select(mainTabPane.getTabs().indexOf(pickerTab.pickerTab));						
		                	}
							
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		            }
		        });  	        
		        
		        mainTabPane.getTabs().add(importSettingsTab.importSettingsTab);		        
		        VBox vBoxMenu = new VBox(controlsHBox, mainTabPane);		        
		       this.reiheAPickerScene = new Scene(vBoxMenu);
		        
		  }
		  primaryStage.setScene(this.reiheAPickerScene);
	
	   }
	
	   private void openLegalInformationScene()
	   {
		   new LegalInformationScene();
	   }
	   
	   public void setPickerTabActive(TabPane mainTabPane, PickerTab pickerTab)
	   {
		   mainTabPane.getSelectionModel().select(mainTabPane.getTabs().indexOf(pickerTab.pickerTab));
	   }
	
}
