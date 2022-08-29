package userInterface_reiheAPicker;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.json.JSONObject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic_reiheAPicker.GetButtonPics;
import logic_reiheAPicker.ImportExportFileHandler;
import logic_reiheAPicker.PropertyFileHandler;
import models_reiheAPicker.PropertyModel;
import var_reiheAPicker.Constants;
import javafx.scene.layout.VBox;

public class ImportSettingsTab {
	
	public Tab importSettingsTab;
	private Stage primaryStage;
	
	public TabPane importSettingsTabSubSettingsTabPane;
	
	public Tab generalSettings;
	public Tab catalogueSettings;
	public Tab markingsSettings;
	public Tab apiSettings;
	private boolean changedFlag = false;
	
	public HBox saveButtonHBox;
	
	
	
	public List<List<String>> titles = null;
	public boolean isSaveFileLoad = false;
	public List<String> saveFilePaths = null;
	public List<String> ColumnNamesFromSaveFile = null;
	public List<List<String>> nopeTitlesFromSaveFile = null;
	public List<List<String>> queueTitlesFromSaveFile = null;
	public List<List<String>> pickTitlesFromSaveFile = null;
	
	PropertyFileHandler propertyFilehandler = PropertyFileHandler.getInstance();
	public GridPane gridpaneGeneral;	
	public GridPane gridpaneCatalogue;	
	public GridPane gridpaneMarkings;	
	public GridPane gridpaneApi;	
	
	
	public VBox globalVBox;
    ScrollPane scrollPane = new ScrollPane();
    
    public Label settingsLabel1;
	public Label settingsLabel2;
	public Label settingsLabel3;
	public Label settingsLabel4;
	public Label settingsLabel5;
	public Label settingsLabel6;
	public Label settingsLabel7;
	
	//searchlabels
	
	public Label settingsLabel8;
	public Label settingsLabel9;
	public Label settingsLabel10;
	public Label settingsLabel11;
	public Label settingsLabel12;
	public Label settingsLabel13;
	public Label settingsLabel14;
	public Label settingsLabel15;
	public Label settingsLabel16;
	public Label settingsLabel17;
	public Label settingsLabel18;
	public Label settingsLabel19;
	
	public Label settingsLabel20;
	public Label settingsLabel21;
	
	public Label settingsLabel22;
	public Label settingsLabel22b;
	public Label settingsLabel22c;
	
	public Label settingsLabel23;
	public Label settingsLabel24;
	public Label settingsLabel25;
	public Label settingsLabel26;
	
	public Label settingsLabel27;
	public Label settingsLabel28;
	public Label settingsLabel29;
	
	public Label generalSettins = new Label(Constants.LabelNameGeneralSettings);
	public Label catalogueSearch = new Label(Constants.LabelNameSearchCatalogueSettings);
	public Label markierungseinstellungen = new Label(Constants.LabelNameMarkingsSettings);
	public Label apisettings = new Label(Constants.LabelNameApiSettings);
	
	public TextField settingsTextField1;
	public TextField settingsTextField2;
	public TextField settingsTextField3;
	public TextField settingsTextField4;
	public CheckBox settingsTextField5_checkbox;
	public CheckBox settingsTextField6_checkbox;
	public TextField settingsTextField7;
	
	//searchtextfields
	public TextField settingsTextField8;
	public TextField settingsTextField9;
	public TextField settingsTextField10;
	public TextField settingsTextField11;
	public TextField settingsTextField12;
	public TextField settingsTextField13;
	public TextField settingsTextField14;
	public TextField settingsTextField15;
	public TextField settingsTextField16;
	public TextField settingsTextField17;
	public TextField settingsTextField18;
	public TextField settingsTextField19;

	public TextField settingsTextField20;
	public TextField settingsTextField21;
	
	public TextField settingsTextField22;
	public TextField settingsTextField22b;
	public TextField settingsTextField22c;
	
	public CheckBox settingsTextField23_checkbox;
	public CheckBox settingsTextField24_checkbox;
	
	public CheckBox settingsTextField25_checkbox;
	public CheckBox settingsTextField26_checkbox;	
	
	public CheckBox settingsTextField27_checkbox;
	public CheckBox settingsTextField28_checkbox;
	public CheckBox settingsTextField29_checkbox;
	
	public Button saveSettingsButton;
	public Button searchExportFolderButton;
	public Button searchSaveFolderButton;
	
	//labels f�r suche; Angabe von Termen damit �berblick leichter
	public Label searchFieldLabel1;
	public Label searchFieldLabel2;
	public Label searchFieldLabel3;
	public Label searchFieldLabel4;
	public Label searchFieldLabel5;
	public Label searchFieldLabel6;
	public Label searchFieldLabel7;
	public Label searchFieldLabel8;
	public Label searchFieldLabel9;
	public Label searchFieldLabel10;
	public Label searchFieldLabel11;
	public Label searchFieldLabel12;
	
	

	
	
	
	
	
		
	public ImportSettingsTab(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		initiateElements();
		configureElements();
	}	
	
	private void initiateElements()
	{
		this.importSettingsTab = new Tab(Constants.ImportSettingsTabName);
		this.generalSettings = new Tab(Constants.GeneralSettingsTabName);
		this.catalogueSettings = new Tab(Constants.CatalogueSettingsTabName);
		this.markingsSettings = new Tab(Constants.MarkingsSettingsTabName);
		this.apiSettings = new Tab(Constants.ApiSettingsTabName);
	
		this.importSettingsTabSubSettingsTabPane = new TabPane();
		this.importSettingsTabSubSettingsTabPane.getTabs().add(this.generalSettings);
		this.importSettingsTabSubSettingsTabPane.getTabs().add(this.catalogueSettings);
		this.importSettingsTabSubSettingsTabPane.getTabs().add(this.markingsSettings);
		this.importSettingsTabSubSettingsTabPane.getTabs().add(this.apiSettings);
		
		
		this.saveButtonHBox = new HBox();
		
		this.gridpaneGeneral = new GridPane();	
		this.gridpaneCatalogue = new GridPane();	
		this.gridpaneMarkings = new GridPane();	
		this.gridpaneApi = new GridPane();	
		
		this.globalVBox = new VBox();
		
		this.settingsLabel1 = new Label(Constants.LabelName1);
		this.settingsLabel2 = new Label(Constants.LabelName2);
		this.settingsLabel3 = new Label(Constants.LabelName3);
		this.settingsLabel4 = new Label(Constants.LabelName4);
		this.settingsLabel5 = new Label(Constants.LabelName5);
		this.settingsLabel6 = new Label(Constants.LabelName6);
		this.settingsLabel7 = new Label(Constants.LabelName7);
		
		
		this.settingsTextField1 = new TextField(propertyFilehandler.propertyFileModel.get_settings_ExportFileFolder());
		this.settingsTextField2 = new TextField(propertyFilehandler.propertyFileModel.get_settings_DDCBlacklist());
		this.settingsTextField3 = new TextField(propertyFilehandler.propertyFileModel.get_settings_DDCWhitelist());		
		this.settingsTextField4 = new TextField(propertyFilehandler.propertyFileModel.get_settings_PublisherBlacklist());
		this.settingsTextField5_checkbox = new CheckBox();
		this.settingsTextField6_checkbox = new CheckBox();
		this.settingsTextField5_checkbox.setSelected(Boolean.parseBoolean(propertyFilehandler.propertyFileModel.get_settings_RemoveDuplicates()));
		this.settingsTextField6_checkbox.setSelected(Boolean.parseBoolean(propertyFilehandler.propertyFileModel.get_settings_BlockBelletristik()));
		this.settingsTextField7 = new TextField(propertyFilehandler.propertyFileModel.get_settings_SaveFileFolder());
		
		this.settingsTextField1.setMinWidth(300);
		this.settingsTextField2.setMinWidth(300);
		this.settingsTextField3.setMinWidth(300);
		this.settingsTextField4.setMinWidth(300);
		this.settingsTextField7.setMinWidth(300);
		this.saveSettingsButton = new Button("Einstellungen übernehmen und speichern!");
		this.searchExportFolderButton = new Button("");
		this.searchSaveFolderButton = new Button("");
		

		this.settingsLabel8 = new Label(Constants.LabelName8);
		this.settingsLabel9 = new Label(Constants.LabelName9);
		this.settingsLabel10 = new Label(Constants.LabelName10);
		this.settingsLabel11 = new Label(Constants.LabelName11);
		this.settingsLabel12 = new Label(Constants.LabelName12);
		this.settingsLabel13 = new Label(Constants.LabelName13);
		this.settingsLabel14 = new Label(Constants.LabelName14);
		this.settingsLabel15 = new Label(Constants.LabelName15);
		this.settingsLabel16 = new Label(Constants.LabelName16);
		this.settingsLabel17 = new Label(Constants.LabelName17);
		this.settingsLabel18 = new Label(Constants.LabelName18);
		this.settingsLabel19 = new Label(Constants.LabelName19);
		
		this.settingsLabel20 = new Label(Constants.LabelName20);
		this.settingsLabel21 = new Label(Constants.LabelName21);
		this.settingsLabel22 = new Label(Constants.LabelName22);
		this.settingsLabel22b = new Label(Constants.LabelName22b);
		this.settingsLabel22c = new Label(Constants.LabelName22c);
		this.settingsLabel23 = new Label(Constants.LabelName23);
		this.settingsLabel24 = new Label(Constants.LabelName24);
		this.settingsLabel25 = new Label(Constants.LabelName25);
		this.settingsLabel26 = new Label(Constants.LabelName26);
		
		this.settingsLabel27 = new Label(Constants.LabelName27);
		this.settingsLabel28 = new Label(Constants.LabelName28);
		this.settingsLabel29 = new Label(Constants.LabelName29);

		this.settingsTextField8 = new TextField(propertyFilehandler.propertyFileModel.get_settings_f1search());
		this.settingsTextField9 = new TextField(propertyFilehandler.propertyFileModel.get_settings_f2search());
		this.settingsTextField10 = new TextField(propertyFilehandler.propertyFileModel.get_settings_f3search());
		this.settingsTextField11 = new TextField(propertyFilehandler.propertyFileModel.get_settings_f4search());
		this.settingsTextField12 = new TextField(propertyFilehandler.propertyFileModel.get_settings_f1searchShift());
		this.settingsTextField13 = new TextField(propertyFilehandler.propertyFileModel.get_settings_f2searchShift());
		this.settingsTextField14 = new TextField(propertyFilehandler.propertyFileModel.get_settings_f3searchShift());
		this.settingsTextField15 = new TextField(propertyFilehandler.propertyFileModel.get_settings_f4searchShift());
		this.settingsTextField16 = new TextField(propertyFilehandler.propertyFileModel.get_settings_f1searchCtrl());
		this.settingsTextField17 = new TextField(propertyFilehandler.propertyFileModel.get_settings_f2searchCtrl());
		this.settingsTextField18 = new TextField(propertyFilehandler.propertyFileModel.get_settings_f3searchCtrl());
		this.settingsTextField19 = new TextField(propertyFilehandler.propertyFileModel.get_settings_f4searchCtrl());	
		this.settingsTextField20 = new TextField(propertyFilehandler.propertyFileModel.get_settings_stichwortmarkierungGruen());
		this.settingsTextField21 = new TextField(propertyFilehandler.propertyFileModel.get_settings_stichwortmarkierungRot());
		this.settingsTextField22 = new TextField(propertyFilehandler.propertyFileModel.get_settings_API_link());
		this.settingsTextField22b = new TextField(propertyFilehandler.propertyFileModel.get_settings_API_isbnSeparator());
		this.settingsTextField22c = new TextField(propertyFilehandler.propertyFileModel.get_settings_API_sigil());
		this.settingsTextField23_checkbox = new CheckBox();
		this.settingsTextField24_checkbox = new CheckBox();
		this.settingsTextField25_checkbox = new CheckBox();
		this.settingsTextField26_checkbox = new CheckBox();
		this.settingsTextField23_checkbox.setSelected(Boolean.parseBoolean(propertyFilehandler.propertyFileModel.get_settings_API_CheckApiAfterImport()));
		this.settingsTextField24_checkbox.setSelected(Boolean.parseBoolean(propertyFilehandler.propertyFileModel.get_settings_API_RemoveHoldings()));
		this.settingsTextField25_checkbox.setSelected(Boolean.parseBoolean(propertyFilehandler.propertyFileModel.get_settings_API_markOA()));
		this.settingsTextField26_checkbox.setSelected(Boolean.parseBoolean(propertyFilehandler.propertyFileModel.get_settings_API_RemoveOA()));
		
		this.settingsTextField27_checkbox = new CheckBox();
		this.settingsTextField27_checkbox.setSelected(Boolean.parseBoolean(propertyFilehandler.propertyFileModel.get_settings_RemoveDuplicatesByTitle()));
		this.settingsTextField28_checkbox = new CheckBox();
		this.settingsTextField28_checkbox.setSelected(Boolean.parseBoolean(propertyFilehandler.propertyFileModel.get_settings_RemoveSchoolBooks()));
		this.settingsTextField29_checkbox = new CheckBox();
		this.settingsTextField29_checkbox.setSelected(Boolean.parseBoolean(propertyFilehandler.propertyFileModel.get_settings_RemoveJuvenileLiterature()));
		
		this.settingsTextField1.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});
				
		this.settingsTextField2.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField3.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField4.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField5_checkbox.selectedProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField6_checkbox.selectedProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField7.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		
		//searchtextfields
		this.settingsTextField8.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField9.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField10.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField11.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField12.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField13.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField14.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField15.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField16.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField17.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField18.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField19.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		

		this.settingsTextField20.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField21.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		
		this.settingsTextField22.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField22b.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField22c.textProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		
		this.settingsTextField23_checkbox.selectedProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField24_checkbox.selectedProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		
		this.settingsTextField25_checkbox.selectedProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField26_checkbox.selectedProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});			
		
		this.settingsTextField27_checkbox.selectedProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField28_checkbox.selectedProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
		this.settingsTextField29_checkbox.selectedProperty().addListener((observable, oldValue, newValue) -> {setChangedFlag();});		
			
	}
	
	
	private void setChangedFlag()
	{
		this.changedFlag = true;
		this.saveButtonHBox.setBackground(new Background(new BackgroundFill(Color.rgb(255, 220, 220), new CornerRadii(5), Insets.EMPTY)));
		
		if (!this.saveButtonHBox.getChildren().contains(this.saveButtonHBox))
				{				
					this.saveButtonHBox.getChildren().clear();
					this.saveButtonHBox.setPadding(new Insets(5,5,5,5));
					this.saveButtonHBox.getChildren().addAll(this.saveSettingsButton, new Label(" Ungespeicherte Einstellungen finden keine Anwendung und gehen nach dem Beenden des Programms verloren!\n Bitte speichern Sie Ihre Einstellungen mit einem Klick auf diesen Button."));
				}
		
	}
	
	private String getLabelContentSearchFields(String content)
	{
		String labelString = "";
		if (content.contains(Constants.isbnWildcard))
		{
			labelString = Constants.isbnWildcardLabel;
		}
		if (content.contains(Constants.authorWildcard))
		{
			if (labelString.isBlank())
			{
				labelString = Constants.authorWildcardLabel;
			} else
			{
				labelString = labelString + " & " + Constants.authorWildcardLabel;
			}			
		}
		if (content.contains(Constants.titleWildcard))
		{
			if (labelString.isBlank())
			{
				labelString = Constants.titleWildcardLabel;
			} else
			{
				labelString = labelString + " & " + Constants.titleWildcardLabel;
			}			
		}
		if (content.contains(Constants.publisherWildcard))
		{
			if (labelString.isBlank())
			{
				labelString = Constants.publisherWildcardLabel;
			} else
			{
				labelString = labelString + " & " + Constants.publisherWildcardLabel;
			}			
		}
		
		
		return labelString;
	}
	
	private void updateSearchFieldLabels()
	{		
		searchFieldLabel1.setText(getLabelContentSearchFields(this.settingsTextField8.getText()));
		searchFieldLabel2.setText(getLabelContentSearchFields(this.settingsTextField9.getText()));
		searchFieldLabel3.setText(getLabelContentSearchFields(this.settingsTextField10.getText()));
		searchFieldLabel4.setText(getLabelContentSearchFields(this.settingsTextField11.getText()));
		searchFieldLabel5.setText(getLabelContentSearchFields(this.settingsTextField12.getText()));
		searchFieldLabel6.setText(getLabelContentSearchFields(this.settingsTextField13.getText()));
		searchFieldLabel7.setText(getLabelContentSearchFields(this.settingsTextField14.getText()));
		searchFieldLabel8.setText(getLabelContentSearchFields(this.settingsTextField15.getText()));
		searchFieldLabel9.setText(getLabelContentSearchFields(this.settingsTextField16.getText()));
		searchFieldLabel10.setText(getLabelContentSearchFields(this.settingsTextField17.getText()));
		searchFieldLabel11.setText(getLabelContentSearchFields(this.settingsTextField18.getText()));
		searchFieldLabel12.setText(getLabelContentSearchFields(this.settingsTextField19.getText()));
	}
	
	
	private void configureElements()
	{
		this.importSettingsTabSubSettingsTabPane.minWidthProperty().bind(this.primaryStage.widthProperty());
		this.importSettingsTabSubSettingsTabPane.minHeightProperty().bind(this.primaryStage.heightProperty());
		
		
		this.importSettingsTab.setClosable(false);
		this.generalSettings.setClosable(false);
		this.catalogueSettings.setClosable(false);
		this.markingsSettings.setClosable(false);
		this.apiSettings.setClosable(false);
		
		this.importSettingsTab.setClosable(false);
		this.generalSettings.setClosable(false);
		this.catalogueSettings.setClosable(false);
		this.markingsSettings.setClosable(false);
		this.apiSettings.setClosable(false);

		this.gridpaneGeneral.setMinHeight(500);
		this.gridpaneCatalogue.setMinHeight(500);	
		this.gridpaneMarkings.setMinHeight(500);
		this.gridpaneApi.setMinHeight(500);

		
		
		this.generalSettins.setStyle("-fx-font-weight: bold");
		this.catalogueSearch.setStyle("-fx-font-weight: bold");
		this.markierungseinstellungen.setStyle("-fx-font-weight: bold");
		this.apisettings.setStyle("-fx-font-weight: bold");		
		
		searchFieldLabel1= new Label(getLabelContentSearchFields(this.settingsTextField8.getText()));
		searchFieldLabel2= new Label(getLabelContentSearchFields(this.settingsTextField9.getText()));
		searchFieldLabel3= new Label(getLabelContentSearchFields(this.settingsTextField10.getText()));
		searchFieldLabel4= new Label(getLabelContentSearchFields(this.settingsTextField11.getText()));
		searchFieldLabel5= new Label(getLabelContentSearchFields(this.settingsTextField12.getText()));
		searchFieldLabel6= new Label(getLabelContentSearchFields(this.settingsTextField13.getText()));
		searchFieldLabel7= new Label(getLabelContentSearchFields(this.settingsTextField14.getText()));
		searchFieldLabel8= new Label(getLabelContentSearchFields(this.settingsTextField15.getText()));
		searchFieldLabel9= new Label(getLabelContentSearchFields(this.settingsTextField16.getText()));
		searchFieldLabel10= new Label(getLabelContentSearchFields(this.settingsTextField17.getText()));
		searchFieldLabel11= new Label(getLabelContentSearchFields(this.settingsTextField18.getText()));
		searchFieldLabel12= new Label(getLabelContentSearchFields(this.settingsTextField19.getText()));
		
	
		this.gridpaneGeneral = new GridPane();	
		this.gridpaneCatalogue = new GridPane();	
		this.gridpaneMarkings = new GridPane();	
		this.gridpaneApi = new GridPane();	
		
		Image saveButtonImage = GetButtonPics.getButtonImage_saveButton();
		Image searchFileOrFolderImage = GetButtonPics.getButtonImage_SearchFolderOrFile();
		
		if (searchFileOrFolderImage != null)
	     {  	
		
	    	this.searchSaveFolderButton = new Button("");
	    	this.searchExportFolderButton.setText(null);
	    	ImageView img = GetButtonPics.turnPicIntoImageView(searchFileOrFolderImage);
	    	img.setFitWidth(22);
	    	img.setFitHeight(22);
		    this.searchExportFolderButton.setGraphic(img);
		    this.searchExportFolderButton.setPadding(new Insets(1,1,1,1));   
	        this.searchSaveFolderButton.setText(null);
	        img = GetButtonPics.turnPicIntoImageView(searchFileOrFolderImage);
	    	img.setFitWidth(22);
	    	img.setFitHeight(22);
	        this.searchSaveFolderButton.setGraphic(img);
	        this.searchSaveFolderButton.setPadding(new Insets(1,1,1,1)); 
	        
	      
	      }
		 
        if (saveButtonImage != null)
        {  	    		
        	
        this.saveSettingsButton.setText(null);
        this.saveSettingsButton.setGraphic(GetButtonPics.turnPicIntoImageView(saveButtonImage));
        this.saveSettingsButton.setPadding(new Insets(5,5,5,5));        
        }
        this.saveButtonHBox.setPadding(new Insets(5,5,5,5));
		
	
        
		this.gridpaneGeneral.add(this.generalSettins, 0, 0); 
		this.gridpaneGeneral.add(this.settingsLabel1, 0, 1); 	this.gridpaneGeneral.add(this.settingsTextField1, 1, 1); this.gridpaneGeneral.add(this.searchExportFolderButton, 2, 1); 	
		this.gridpaneGeneral.add(this.settingsLabel7, 0, 2); 	this.gridpaneGeneral.add(this.settingsTextField7, 1, 2); this.gridpaneGeneral.add(this.searchSaveFolderButton, 2, 2); 	
		
		//this.gridpaneGeneral.add(this.settingsLabel7, 0, 1);	this.gridpaneGeneral.add(this.settingsTextField7, 1, 1);
		//this.gridpaneGeneral.add(this.settingsLabel2, 0, 2); 	this.gridpaneGeneral.add(this.settingsTextField2, 1, 2);
		this.gridpaneGeneral.add(this.settingsLabel3, 0, 3);	this.gridpaneGeneral.add(this.settingsTextField3, 1, 3); this.gridpaneGeneral.add(new Text("Angabe von erlaubten DDCs. (z.b. '200+;350+;440' entspricht 200-299.999, 350-399.999 und 440)"), 2, 3);
		this.gridpaneGeneral.add(this.settingsLabel4, 0, 4);	this.gridpaneGeneral.add(this.settingsTextField4, 1, 4); this.gridpaneGeneral.add(new Text("Angabe von auszusortierenden Verlagen. (z.b. 'Springer Nature;Wiley')"), 2, 4);
		this.gridpaneGeneral.add(this.settingsLabel5, 0, 5);	this.gridpaneGeneral.add(this.settingsTextField5_checkbox, 1, 5); 
		this.gridpaneGeneral.add(this.settingsLabel27, 0, 6); this.gridpaneGeneral.add(this.settingsTextField27_checkbox, 1, 6);
		this.gridpaneGeneral.add(this.settingsLabel28, 0, 7); this.gridpaneGeneral.add(this.settingsTextField28_checkbox, 1, 7); 
		this.gridpaneGeneral.add(this.settingsLabel29, 0, 8); this.gridpaneGeneral.add(this.settingsTextField29_checkbox, 1, 8);
		this.gridpaneGeneral.add(this.settingsLabel6, 0, 9);	this.gridpaneGeneral.add(this.settingsTextField6_checkbox, 1, 9);
		
		this.gridpaneCatalogue.add(this.catalogueSearch, 0, 0); this.gridpaneCatalogue.add(new Text("Variablen: [{[author]}], [{[title]}], [{[isbn]}], [{[publisher]}]"), 1, 7);
		this.gridpaneCatalogue.add(this.settingsLabel8, 0, 1);	this.gridpaneCatalogue.add(this.settingsTextField8, 1, 1);	this.gridpaneCatalogue.add(this.searchFieldLabel1, 2, 1);
		this.gridpaneCatalogue.add(this.settingsLabel9, 0, 2);	this.gridpaneCatalogue.add(this.settingsTextField9, 1, 2);	this.gridpaneCatalogue.add(this.searchFieldLabel2, 2, 2);
		this.gridpaneCatalogue.add(this.settingsLabel10, 0, 3);	this.gridpaneCatalogue.add(this.settingsTextField10, 1, 3);	this.gridpaneCatalogue.add(this.searchFieldLabel3, 2, 3);
		this.gridpaneCatalogue.add(this.settingsLabel11, 0, 4);	this.gridpaneCatalogue.add(this.settingsTextField11, 1, 4);	this.gridpaneCatalogue.add(this.searchFieldLabel4, 2, 4);
		this.gridpaneCatalogue.add(this.settingsLabel12, 0, 5);	this.gridpaneCatalogue.add(this.settingsTextField12, 1, 5);	this.gridpaneCatalogue.add(this.searchFieldLabel5, 2, 5);
		this.gridpaneCatalogue.add(this.settingsLabel13, 0, 6);	this.gridpaneCatalogue.add(this.settingsTextField13, 1, 6);	this.gridpaneCatalogue.add(this.searchFieldLabel6, 2, 6);
		this.gridpaneCatalogue.add(this.settingsLabel14, 0, 7);	this.gridpaneCatalogue.add(this.settingsTextField14, 1, 7);	this.gridpaneCatalogue.add(this.searchFieldLabel7, 2, 7);
		this.gridpaneCatalogue.add(this.settingsLabel15, 0, 8);	this.gridpaneCatalogue.add(this.settingsTextField15, 1, 8);	this.gridpaneCatalogue.add(this.searchFieldLabel8, 2, 8);
		this.gridpaneCatalogue.add(this.settingsLabel16, 0, 9);	this.gridpaneCatalogue.add(this.settingsTextField16, 1, 9);	this.gridpaneCatalogue.add(this.searchFieldLabel9, 2, 9);
		this.gridpaneCatalogue.add(this.settingsLabel17, 0, 10);	this.gridpaneCatalogue.add(this.settingsTextField17, 1, 10);	this.gridpaneCatalogue.add(this.searchFieldLabel10, 2, 10);
		this.gridpaneCatalogue.add(this.settingsLabel18, 0, 11);	this.gridpaneCatalogue.add(this.settingsTextField18, 1, 11);	this.gridpaneCatalogue.add(this.searchFieldLabel11, 2, 11);
		this.gridpaneCatalogue.add(this.settingsLabel19, 0, 12);	this.gridpaneCatalogue.add(this.settingsTextField19, 1, 12);	this.gridpaneCatalogue.add(this.searchFieldLabel12, 2, 12);	
		
		this.gridpaneMarkings.add(this.markierungseinstellungen , 0, 0);
		this.gridpaneMarkings.add(this.settingsLabel20, 0, 1);	this.gridpaneMarkings.add(this.settingsTextField20, 1, 1);	this.gridpaneMarkings.add(new Text("z.b. 'Pädagogik;Sozialwissenschaft;Herder;DDC-Sachgruppe:S;Verlagsort:Freiburg'"), 2, 1);
		this.gridpaneMarkings.add(this.settingsLabel21, 0, 2);	this.gridpaneMarkings.add(this.settingsTextField21, 1, 2);	this.gridpaneMarkings.add(new Text("z.b. 'Scientology;Grin-Verlag;DDC-Sachgruppe:B;Autor:Guttenberg;Auflage:Unver'"), 2, 2);	
		this.gridpaneMarkings.add(this.settingsLabel25, 0, 3);	this.gridpaneMarkings.add(this.settingsTextField25_checkbox, 1, 3);
		
		
		this.gridpaneApi.add(this.apisettings , 0, 0);
		this.gridpaneApi.add(this.settingsLabel22, 0, 1);	this.gridpaneApi.add(this.settingsTextField22, 1, 1);	this.gridpaneApi.add(new HBox(this.settingsLabel22b, new Label(" "), this.settingsTextField22b,new Label(" "), this.settingsLabel22c,new Label(" "), this.settingsTextField22c),  2, 1);
		this.gridpaneApi.add(this.settingsLabel23, 0, 2);	this.gridpaneApi.add(this.settingsTextField23_checkbox, 1, 2);	this.gridpaneApi.add(new Text("Sämtliche Datensätze werden bereits beim Laden auf Bestand und OA-Status geprüft und ggf. aussortiert. (Ladezeit ca. 0,5 Sekunden je Titel)"), 2, 2);	
		this.gridpaneApi.add(this.settingsLabel24, 0, 3);	this.gridpaneApi.add(this.settingsTextField24_checkbox, 1, 3); 	
		this.gridpaneApi.add(this.settingsLabel26, 0, 4);	this.gridpaneApi.add(this.settingsTextField26_checkbox, 1, 4);
			
	
		
																																																
																											
		this.gridpaneGeneral.setHgap(10);
		this.gridpaneGeneral.setVgap(10);
		this.gridpaneGeneral.setPadding(new Insets(10,10,10,10));
		
		this.gridpaneCatalogue.setHgap(10);
		this.gridpaneCatalogue.setVgap(10);
		this.gridpaneCatalogue.setPadding(new Insets(10,10,10,10));
		
		this.gridpaneMarkings.setHgap(10);
		this.gridpaneMarkings.setVgap(10);
		this.gridpaneMarkings.setPadding(new Insets(10,10,10,10));
		
		this.gridpaneApi.setHgap(10);
		this.gridpaneApi.setVgap(10);
		this.gridpaneApi.setPadding(new Insets(10,10,10,10));
		
		saveSettingsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {              	
            	try {            		
					updateAndSaveProperties();
					updateSearchFieldLabels();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
 
            }
        });
		
		searchSaveFolderButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {              	
            	getFolderName(false);
 
            }
        });
		
		searchExportFolderButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {              	
            	getFolderName(true);
 
            }
        });
		
		
		this.settingsTextField23_checkbox.selectedProperty().addListener((observable, oldValue, newValue) -> {		
			updateTextField24();
			updateTextField26();
	});		
		
		updateTextField24();
		updateTextField26();
		
		
		
		this.generalSettings.setContent(this.gridpaneGeneral);
		this.catalogueSettings.setContent(this.gridpaneCatalogue);
		this.markingsSettings.setContent(this.gridpaneMarkings);
		this.apiSettings.setContent(this.gridpaneApi);
		
		
		
		
		this.globalVBox.getChildren().addAll(this.saveButtonHBox, this.importSettingsTabSubSettingsTabPane);
		this.scrollPane.setContent(this.globalVBox);
		this.importSettingsTab.setContent(this.scrollPane);
		
	}	
	
	private void updateTextField24()
	{
		/*
		if (this.settingsTextField23_checkbox.isSelected())
		{
			this.settingsTextField24_checkbox.setVisible(true);				
		} else
		{
			this.settingsTextField24_checkbox.setVisible(false);
		}
		*/		
	}
	
	private void updateTextField26()
	{
		/*
		if (this.settingsTextField23_checkbox.isSelected())
		{
			this.settingsTextField26_checkbox.setVisible(true);				
		} else
		{
			this.settingsTextField26_checkbox.setVisible(false);
		}
		*/
	}
	
	private void updateAndSaveProperties() throws IOException
	{
		
		
		if(!this.settingsTextField1.getText().substring(this.settingsTextField1.getText().length() - 1).equals("\\"))
		{
			this.settingsTextField1.setText(this.settingsTextField1.getText() + "\\");
		}
		if(!this.settingsTextField7.getText().substring(this.settingsTextField7.getText().length() - 1).equals("\\"))
		{
			this.settingsTextField7.setText(this.settingsTextField7.getText() + "\\");
		}
		if(this.settingsTextField3.getText().contains(" "))
		{
			this.settingsTextField3.setText(this.settingsTextField3.getText().replace(" ", ""));
		}
		if(this.settingsTextField4.getText().contains("; ") || this.settingsTextField4.getText().contains(" ;"))
		{
			this.settingsTextField4.setText(this.settingsTextField4.getText().replace("; ", ";"));
			this.settingsTextField4.setText(this.settingsTextField4.getText().replace(" ;", ";"));
		}		
		
		if(this.settingsTextField20.getText().contains("; ") || this.settingsTextField20.getText().contains(" ;"))
		{
			this.settingsTextField20.setText(this.settingsTextField20.getText().replace("; ", ";"));
			this.settingsTextField20.setText(this.settingsTextField20.getText().replace(" ;", ";"));
		}	
		if(this.settingsTextField21.getText().contains("; ") || this.settingsTextField21.getText().contains(" ;"))
		{
			this.settingsTextField21.setText(this.settingsTextField21.getText().replace("; ", ";"));
			this.settingsTextField21.setText(this.settingsTextField21.getText().replace(" ;", ";"));
		}	
		
		this.propertyFilehandler.propertyFileModel.updateProperties(this.settingsTextField1.getText(),this.settingsTextField7.getText(), this.settingsTextField4.getText(),booleanToString(this.settingsTextField5_checkbox),this.settingsTextField2.getText(),this.settingsTextField3.getText(), booleanToString(this.settingsTextField6_checkbox),
				this.settingsTextField8 .getText(), this.settingsTextField9 .getText(), this.settingsTextField10.getText(), this.settingsTextField11.getText(), this.settingsTextField12.getText(), this.settingsTextField13.getText(), this.settingsTextField14.getText(), this.settingsTextField15.getText(), this.settingsTextField16.getText(), this.settingsTextField17.getText(), this.settingsTextField18.getText(), this.settingsTextField19.getText(),	
				this.settingsTextField20.getText(), this.settingsTextField21.getText(),
				this.settingsTextField22.getText(),
				booleanToString(this.settingsTextField23_checkbox) , booleanToString(this.settingsTextField24_checkbox),
				this.settingsTextField22b.getText(),this.settingsTextField22c.getText(),
				booleanToString(this.settingsTextField25_checkbox),booleanToString(this.settingsTextField26_checkbox),
				booleanToString(this.settingsTextField27_checkbox),
				booleanToString(this.settingsTextField28_checkbox),booleanToString(this.settingsTextField29_checkbox)
				);		
		
		this.propertyFilehandler.setConfigDetail();			
		this.changedFlag = false;
		this.saveButtonHBox.setBackground(null);
		this.saveButtonHBox.getChildren().clear();
		


	}
	
	
	
	public String booleanToString(CheckBox checkbox)
	{
		if (checkbox.isSelected())
		{
			return "true";
		}
		return "false";
	}
	
	private void getFolderName(boolean tf1truetf7false)
	{		
		if (tf1truetf7false)
		{
			this.settingsTextField1.setText(ImportExportFileHandler.getFileOrFolder(false).getAbsolutePath());
		} else
		{
			this.settingsTextField7.setText(ImportExportFileHandler.getFileOrFolder(false).getAbsolutePath());
		}
		 
	}
	
	public void openFileAndLoad() throws IOException
	{
		this.titles = ImportExportFileHandler.importCsvOrTsvOrPsf();
		
		// if you see this, know that I am fully aware that I have sinned.
		// dont judge. (what could go wrong?)		
		if (this.titles.toString().contains("[Picker Save File]"))
		{
			
			this.isSaveFileLoad = true;
			this.saveFilePaths = this.titles.get(0);
			
			String filename_c = this.titles.get(1).get(0);
			String filename_n = this.titles.get(2).get(0);
			String filename_q = this.titles.get(3).get(0);
			String filename_p = this.titles.get(4).get(0);
				
			this.ColumnNamesFromSaveFile = ImportExportFileHandler.getFileStringListFromFile(new File(filename_c)).get(0);			
			this.nopeTitlesFromSaveFile = ImportExportFileHandler.getFileStringListFromFile(new File(filename_n));
			this.queueTitlesFromSaveFile = ImportExportFileHandler.getFileStringListFromFile(new File(filename_q));
			this.pickTitlesFromSaveFile = ImportExportFileHandler.getFileStringListFromFile(new File(filename_p));				
						
		}
	}


	

				
}