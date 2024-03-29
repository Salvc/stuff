package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.DoubleStringConverter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class Controller {
    Stage primaryStage;
    public Pane myPane;
    public TableView myTableView;
    public TableColumn myTableColumn1;
    public TableColumn myTableColumn2;
    public TableColumn myTableColumn3;
    public TableColumn myTableColumn4;
    public TableColumn myTableColumn5;
    public TableColumn myTableColumn6;
    public TableColumn myTableColumn7;
    public TableColumn myTableColumn8;
    public TableColumn myTableColumn9;
    public Button importButton;
    public Button importImageButton;
    public Button deleteRowButton;
    public Button addRowButton;
    public ImageView myImageView2;
    private final String savedDataFilePath = "/tmp/FastFoodData";

    public void initialize() {
        // load data into table view
        myTableColumn1.setCellValueFactory(new PropertyValueFactory<FastFoods, String>("chainName"));
    myTableColumn2.setCellValueFactory(new PropertyValueFactory<FastFoods, String>("name"));
    myTableColumn3.setCellValueFactory(new PropertyValueFactory<FastFoods, Integer>("servingSize"));
    myTableColumn4.setCellValueFactory(new PropertyValueFactory<FastFoods, Integer>("calories"));
    myTableColumn5.setCellValueFactory(new PropertyValueFactory<FastFoods, Double>("totalFat"));
    myTableColumn6.setCellValueFactory(new PropertyValueFactory<FastFoods, Integer>("sodium"));
    myTableColumn7.setCellValueFactory(new PropertyValueFactory<FastFoods, Integer>("carbs"));
    myTableColumn8.setCellValueFactory(new PropertyValueFactory<FastFoods, Integer>("transFat"));
    myTableColumn9.setCellValueFactory(new PropertyValueFactory<FastFoods, Integer>("saturatedFat"));
        myTableColumn1.setEditable(true);
        myTableColumn2.setEditable(true);
        myTableColumn3.setEditable(true);
        myTableColumn4.setEditable(true);
        myTableColumn5.setEditable(true);
        myTableColumn6.setEditable(true);
        myTableColumn7.setEditable(true);
        myTableColumn8.setEditable(true);
        myTableColumn9.setEditable(true);


        myTableColumn1.setCellFactory(TextFieldTableCell.forTableColumn());
myTableColumn1.setOnEditCommit(
        new EventHandler<TableColumn.CellEditEvent>() {
            @Override
            public void handle(TableColumn.CellEditEvent c) {
                ((FastFoods) c.getTableView().getItems().get(c.getTablePosition().getRow())).setChainName((String)c.getNewValue());
            }
        }
);

        myTableColumn2.setCellFactory(TextFieldTableCell.forTableColumn());
        myTableColumn2.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent c) {
                        ((FastFoods) c.getTableView().getItems().get(c.getTablePosition().getRow())).setName((String)c.getNewValue());
                    }
                }
        );
        myTableColumn3.setCellFactory(TextFieldTableCell.<FastFoods, Integer>forTableColumn(new IntegerStringConverter()));
        myTableColumn3.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent c) {
                        ((FastFoods) c.getTableView().getItems().get(c.getTablePosition().getRow())).setServingSize((int)c.getNewValue());
                    }
                }
        );
        myTableColumn4.setCellFactory(TextFieldTableCell.<FastFoods, Integer>forTableColumn(new IntegerStringConverter()));
        myTableColumn4.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent c) {
                        ((FastFoods) c.getTableView().getItems().get(c.getTablePosition().getRow())).setCalories((int)c.getNewValue());
                    }
                }
        );
        myTableColumn5.setCellFactory(TextFieldTableCell.<FastFoods, Double>forTableColumn(new DoubleStringConverter()));
        myTableColumn5.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent c) {
                        ((FastFoods) c.getTableView().getItems().get(c.getTablePosition().getRow())).setTotalFat((double)c.getNewValue());
                    }
                }
        );

        myTableColumn6.setCellFactory(TextFieldTableCell.<FastFoods, Integer>forTableColumn(new IntegerStringConverter()));
        myTableColumn6.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent c) {
                        ((FastFoods) c.getTableView().getItems().get(c.getTablePosition().getRow())).setSodium((int)c.getNewValue());
                    }
                }
        );
        myTableColumn7.setCellFactory(TextFieldTableCell.<FastFoods, Integer>forTableColumn(new IntegerStringConverter()));
        myTableColumn7.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent c) {
                        ((FastFoods) c.getTableView().getItems().get(c.getTablePosition().getRow())).setCarbs((int)c.getNewValue());
                    }
                }
        );
        myTableColumn8.setCellFactory(TextFieldTableCell.<FastFoods, Integer>forTableColumn(new IntegerStringConverter()));
        myTableColumn8.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent c) {
                        ((FastFoods) c.getTableView().getItems().get(c.getTablePosition().getRow())).setTransFat((int)c.getNewValue());
                    }
                }
        );
        myTableColumn9.setCellFactory(TextFieldTableCell.<FastFoods, Integer>forTableColumn(new IntegerStringConverter()));
        myTableColumn9.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent c) {
                        ((FastFoods) c.getTableView().getItems().get(c.getTablePosition().getRow())).setSaturatedFat((int)c.getNewValue());
                    }
                }
        );

        myTableView.setItems(FastFoods.getFastFoodsList());
        myTableView.getSelectionModel().selectFirst();

        myTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                System.out.println("tableview selection changed");
                FastFoods fastFood = (FastFoods)myTableView.getSelectionModel().getSelectedItem();
                if (fastFood.getMyImage() != null) {
                    myImageView2.setImage(fastFood.getMyImage());
                } else {
                    myImageView2.setImage(null);
                }
            }
        });


//        int size = FastFoods.getAmount();
//        for (int i = 0; i < size; i = i + 1) {
//
//            myTableView.getItems().add(FastFoods.getFastFood(i));
//
        File savedDataFile = new File(savedDataFilePath);
        if (savedDataFile.exists()) {
            try {
                FileInputStream file = new FileInputStream(savedDataFilePath);
                FastFoods.restoreData(file);
                file.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
//
//        }


    }

    public void importData() {
        // Bring up File chooser to choose image
        FileChooser dataFileChooser = new FileChooser();
        dataFileChooser.setTitle("Choose File");
        File dataFile = dataFileChooser.showOpenDialog(this.primaryStage);
        // Check if an image was chosen
        if (dataFile != null) {
            // Update model
            FastFoods.importFastFoods(dataFile);
            // Table will be updated automatically
        }
    }

    public void addRow() {
        // Update model
        FastFoods.addFastFood();
    }
    public void save() {
        try {
            // Save model
            FileOutputStream file = new FileOutputStream(savedDataFilePath);
            FastFoods.saveData(file);
            file.close();
            // Update status
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void deleteRow() {
        // Selected album
        FastFoods fastFoods = (FastFoods)myTableView.getSelectionModel().getSelectedItem();
        if (fastFoods != null) {
            // Update model
            FastFoods.deleteFastFood(fastFoods);
            // Update status
        }
    }
    public void updateMyImage() {
        // Bring up File chooser to choose image
        FileChooser imageChooser = new FileChooser();
        imageChooser.setTitle("Choose Image");
        // Only let JPG and PNGs to be chosen
        imageChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", ".gif" )
        );
        File imageFile = imageChooser.showOpenDialog(this.primaryStage);
        // Check if an image was chosen
        if (imageFile != null) {
            Image newImage = new Image(imageFile.toURI().toString());
            // Update UI
            myImageView2.setImage(newImage);

            // Update model
            FastFoods fastFood = (FastFoods)myTableView.getSelectionModel().getSelectedItem();
            fastFood.setMyImage(newImage);
            // Update status
        }

    }

    public void rowSelected() {
        FastFoods fastFood = (FastFoods)myTableView.getSelectionModel().getSelectedItem();
        if (fastFood.getMyImage() != null) {
            myImageView2.setImage(fastFood.getMyImage());
        }
    }
}
