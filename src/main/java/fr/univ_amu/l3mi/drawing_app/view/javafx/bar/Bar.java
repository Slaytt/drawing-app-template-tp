package fr.univ_amu.l3mi.drawing_app.view.javafx.bar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bar extends HBox {
    private final Map<String, Labeled> labeledElements = new HashMap<>();
    private final Map<String, Button> buttons = new HashMap<>();
    private final Map<String, ColorPicker> colorPickers = new HashMap<>();
    private final Map<String, ComboBox<String>> comboBoxes = new HashMap<>();

    public Bar() {
        super();
        setSpacing(10);
        setPrefHeight(30);
        setAlignment(Pos.CENTER);
    }

    public void addLabel(String id, String initialText){
        if(labeledElements.containsKey(id)){
            throw new IllegalArgumentException("Label " + id + " already exists");
        }
        Label label = new Label(initialText);
        label.setAlignment(Pos.BASELINE_CENTER);
        labeledElements.put(id, label);
        this.getChildren().add(label);
    }

    public void setButtonAction(String id, ButtonActionOnClick buttonActionOnClick){
       buttons.get(id).setOnAction(_ -> buttonActionOnClick.onClick());
    }


    public Color getPickedColor(String id){
        return colorPickers.get(id).getValue();
    }

    public String getPickedChoice(String id){
        return comboBoxes.get(id).getValue();
    }

    public void setColorPickerAction(String id, ColorPickedAction colorPickedAction){
        ColorPicker colorPicker = colorPickers.get(id);
        colorPicker.setOnAction(_ -> colorPickedAction.onColorPicked(colorPicker.getValue()));
    }

    public void setComboBoxAction(String id, ChoicePickedAction choicePickedAction){
        ComboBox<String> comboBox = comboBoxes.get(id);
        comboBox.setOnAction(_ -> choicePickedAction.onChoicePicked(comboBox.getValue()));
    }

    public void addButton(String id, String label){
        Button button = new Button(label);
        labeledElements.put(id, button);
        buttons.put(id, button);
        this.getChildren().add(button);
    }

    public void addColorPicker(String id, String label){
        addLabel(id+"Label", label);
        ColorPicker colorPicker = new ColorPicker();
        colorPickers.put(id, colorPicker);
        this.getChildren().add(colorPicker);
    }

    public void addComboBox(String id, String label, List<String> choices){
        addLabel(id+"Label", label);
        ComboBox<String> comboBox = new ComboBox<>(FXCollections.observableList(choices));
        comboBox.setValue(choices.getFirst());
        comboBoxes.put(id, comboBox);
        this.getChildren().add(comboBox);
    }

    public void updateLabel(String id, String newText){
        if(labeledElements.containsKey(id)){
            labeledElements.get(id).setText(newText);
        }
    }

    public void updateColorPicker(String id, Color newColor){
        if(colorPickers.containsKey(id)){
            colorPickers.get(id).setValue(newColor);
        }
    }
    public void updateComboBox(String id, String choice){
        if(comboBoxes.containsKey(id)){
            comboBoxes.get(id).setValue(choice);
        }
    }

}
