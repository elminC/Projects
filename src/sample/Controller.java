package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import sun.awt.SunHints;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Pane pane;

    @FXML
    ImageView prviitem_picbox;

    @FXML
    ImageView drugiitem_picbox;

    @FXML
    ImageView rezultat_picbox;
    @FXML
    TextArea text_field;

    @FXML
    private ListView<String> listaitema_listview;

    int prviItem=-1, drugiItem=-1;


    ObservableList<String> list = FXCollections.observableArrayList("BF Sword", "Needlessly large rod", "Chain Vest", "Recurve Bow", "Tear of the Goddess");

    Image bfSword = new Image("Slika/Ad item.jpg", 30, 30, false, false);
    Image nlp = new Image("Slika/Ap item.jpg", 30, 30, false, false);
    Image chainWest = new Image("Slika/Chain_Vest_item.png", 30, 30, false, false);
    Image recurveBow = new Image("Slika/Recurve_Bow_item.png", 30, 30, false, false);
    Image totg = new Image("Slika/Tear_of_the_Goddess_item.png", 30, 30, false, false);
    Image frozenHeart = new Image("Slika/Frozen_Heart_item.png");
    Image guardianAngel = new Image("Slika/Guardian_Angel_item.png");
    Image rageblade = new Image("Slika/Guinsoo's_Rageblade_item.png");
    Image gunblade = new Image("Slika/Gunblade.jpg");
    Image iE = new Image("Slika/Infinity_Edge_item.png");
    Image locketotI = new Image("Slika/Locket_of_the_Iron_Solari_item.png");
    Image ludens = new Image("Slika/Luden's_Echo_item.png");
    Image pD = new Image("Slika/Phantom_Dancer_item.png");
    Image rabadons = new Image("Slika/Rabadon's_Deathcap_item.png");
    Image rfc = new Image("Slika/Rapid_Firecannon_item.png");
    Image seraphsE = new Image("Slika/Seraph's_Embrace_item.png");
    Image soS = new Image("Slika/Spear_of_Shojin_item.png");
    Image sShiv = new Image("Slika/Statikk_Shiv_item.png");
    Image sotd = new Image("Slika/Sword_of_the_Divine_item.png");
    Image thorn = new Image("Slika/Thornmail_item.png");

    Image[] rezultatItema = {
            frozenHeart, guardianAngel, rageblade, gunblade, iE, locketotI, ludens, pD, rabadons, rfc, seraphsE, soS, sShiv, sotd, thorn};

    Image[] listofImages = {
            bfSword, nlp, chainWest, recurveBow, totg};

    BackgroundImage myBI = new BackgroundImage(new Image("Slika/Background.png", 709, 469, false, true),
            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);


    @Override
    public void initialize(URL location, ResourceBundle resource) {
        pane.setBackground(new Background(myBI));
        listaitema_listview.setItems(list);
        listaitema_listview.setCellFactory(param -> new ListCell<String>() {
            ImageView img = new ImageView();

            public void updateItem(String name, boolean empty) {
                super.updateItem(name, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    if (name.equals("BF Sword"))
                        img.setImage(listofImages[0]);
                    else if (name.equals("Needlessly large rod"))
                        img.setImage(listofImages[1]);
                    else if (name.equals("Chain Vest"))
                        img.setImage(listofImages[2]);
                    else if (name.equals("Recurve Bow"))
                        img.setImage(listofImages[3]);
                    else if (name.equals("Tear of the Goddess"))
                        img.setImage(listofImages[4]);
                    setText(name);
                    setGraphic(img);

                }
            }


        });


        listaitema_listview.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> ov,
                                        String old_val, String new_val) {

                        if (prviItem < 0  ) {
                            prviitem_picbox.setImage(listofImages[listaitema_listview.getSelectionModel().getSelectedIndex()]);
                            prviItem = listaitema_listview.getSelectionModel().getSelectedIndex();
                            rezultat();

                        } else if ( prviItem >-1){

                            drugiitem_picbox.setImage(listofImages[listaitema_listview.getSelectionModel().getSelectedIndex()]);
                            drugiItem = listaitema_listview.getSelectionModel().getSelectedIndex();
                            rezultat();

                        }
                        else{
                            rezultat();

                        }


                    }
                });
        text_field.setWrapText(true);



    }


    private void rezultat() {
        if (prviItem == 0 && drugiItem == 0) {
            rezultat_picbox.setImage(rezultatItema[4]);
            text_field.setText("Critical Strikes deal +200% damage.");

        } else if (prviItem == 0 && drugiItem == 1) {
            rezultat_picbox.setImage(rezultatItema[3]);
            text_field.setText("Heal for 25% of all damage dealt.");

        } else if (prviItem == 0 && drugiItem == 2) {
            rezultat_picbox.setImage(rezultatItema[1]);
            text_field.setText("On taking lethal damage instead enter stasis, cleansing negative effects and recovering up to 500 Health.");

        } else if (prviItem == 0 && drugiItem == 3) {
            rezultat_picbox.setImage(rezultatItema[13]);
            text_field.setText("Each second, the wearer has a 7% chance to gain 100% Critical Strike.");

        } else if (prviItem == 0 && drugiItem == 4) {
            rezultat_picbox.setImage(rezultatItema[11]);
            text_field.setText("After casting, wearer gains 15% of its max Mana per attack.");

        } else if (prviItem == 1 && drugiItem == 0) {
            rezultat_picbox.setImage(rezultatItema[3]);
            text_field.setText("Heal for 25% of all damage dealt.");

        } else if (prviItem == 1 && drugiItem == 1) {
            rezultat_picbox.setImage(rezultatItema[8]);
            text_field.setText("Wearer's Spell Power stat is amplified by 50%.");

        } else if (prviItem == 1 && drugiItem == 2) {
            rezultat_picbox.setImage(rezultatItema[5]);
            text_field.setText("At the start of combat, allies within 2 hexes in the same row gain a shield that blocks 250 damage.");

        } else if (prviItem == 1 && drugiItem == 3) {
            rezultat_picbox.setImage(rezultatItema[2]);
            text_field.setText("Attacks grant 5% Attack Speed. Stacks infinitely.");

        } else if (prviItem == 1 && drugiItem == 4) {
            rezultat_picbox.setImage(rezultatItema[6]);
            text_field.setText("Spells deal 180 splash damage on hit.");

        } else if (prviItem == 2 && drugiItem == 0) {
            rezultat_picbox.setImage(rezultatItema[1]);
            text_field.setText("On taking lethal damage instead enter stasis, cleansing negative effects and recovering up to 500 Health.");

        } else if (prviItem == 2 && drugiItem == 1) {
            rezultat_picbox.setImage(rezultatItema[5]);
            text_field.setText("At the start of combat, allies within 2 hexes in the same row gain a shield that blocks 250 damage.");

        } else if (prviItem == 2 && drugiItem == 2) {
            rezultat_picbox.setImage(rezultatItema[14]);
            text_field.setText("Reflect 100% of damage mitigated from attacks.");

        } else if (prviItem == 2 && drugiItem == 3) {
            rezultat_picbox.setImage(rezultatItema[7]);
            text_field.setText("Wearer dodges all Critical Strikes.");

        } else if (prviItem == 2 && drugiItem == 4) {
            rezultat_picbox.setImage(rezultatItema[0]);
            text_field.setText("Adjacent enemies lose 25% Attack Speed.");

        }else if (prviItem == 3 && drugiItem == 4) {
            rezultat_picbox.setImage(rezultatItema[12]);
            text_field.setText("Every 3rd attack deals 100 magical damage to 3 enemies.");

        } else if (prviItem == 3 && drugiItem == 0) {
            rezultat_picbox.setImage(rezultatItema[13]);
            text_field.setText("Each second, the wearer has a 7% chance to gain 100% Critical Strike.");

        } else if (prviItem == 3 && drugiItem == 1) {
            rezultat_picbox.setImage(rezultatItema[2]);
            text_field.setText("Attacks grant 5% Attack Speed. Stacks infinitely.");

        } else if (prviItem == 3 && drugiItem == 2) {
            rezultat_picbox.setImage(rezultatItema[7]);
            text_field.setText("Wearer dodges all Critical Strikes.");

        } else if (prviItem == 3 && drugiItem == 3) {
            rezultat_picbox.setImage(rezultatItema[9]);
            text_field.setText("Wearer's attacks cannot be dodged. Attack Range is doubled.");

        } else if (prviItem == 4 && drugiItem == 0) {
            rezultat_picbox.setImage(rezultatItema[11]);
            text_field.setText("After casting, wearer gains 15% of its max Mana per attack.");

        } else if (prviItem == 4 && drugiItem == 1) {
            rezultat_picbox.setImage(rezultatItema[6]);
            text_field.setText("Spells deal 180 splash damage on hit.");

        } else if (prviItem == 4 && drugiItem == 2) {
            rezultat_picbox.setImage(rezultatItema[0]);
            text_field.setText("Adjacent enemies lose 25% Attack Speed.");

        } else if (prviItem == 4 && drugiItem == 3) {
            rezultat_picbox.setImage(rezultatItema[12]);
            text_field.setText("Every 3rd attack deals 100 magical damage to 3 enemies.");

        } else if (prviItem == 4 && drugiItem == 4) {
            rezultat_picbox.setImage(rezultatItema[10]);
            text_field.setText("Wearer regains 20 mana after spellcast.");

        } else {
            rezultat_picbox.setImage(null);
        }
    }

    public void pick_clicked(MouseEvent mouseEvent) {
        prviitem_picbox.setImage(null);
        prviItem = -1 ;
        text_field.clear();
        rezultat();

    }

    public void drugiitem_click(MouseEvent mouseEvent) {
        drugiitem_picbox.setImage(null);
        drugiItem = -2;
        text_field.clear();
        rezultat();
    }
}
