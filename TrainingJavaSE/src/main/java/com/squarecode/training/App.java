/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.squarecode.training;

import com.squarecode.training.view.MainView;

/**
 * Author   : @dynastymasra
 * User     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */
public class App {
    public static void main(String[] args) {
        Themes themes = new Themes();
        themes.startup();
        
        MainView mainView = new MainView();
        mainView.setVisible(true);
    }
}
