package com.sandun.web.model;

import java.awt.Color;
import javax.swing.JComponent;

public class ClickEffectManager {

    public static final int HOLD = 1;
    public static final int HOLD_BLINK = 2;
    public static final int BLINK = 3;

    private Color normalState;
    private boolean animationState;
    private Color clickedState;
    private JComponent clickedComponent;
    private JComponent previousComponent;

    public ClickEffectManager(Color normalState, Color clickedState) {
        this.normalState = normalState;
        this.clickedState = clickedState;
    }

    public void showEffect(JComponent comp, int effectType) {
        previousComponent = clickedComponent;
        if (previousComponent != null) {
            previousComponent.setBackground(normalState);
        }
        clickedComponent = comp;
        switch (effectType) {
            case HOLD_BLINK:
                holdBlinkEffect();
                break;
            case BLINK:
                blinkEffect();
                break;
            default:
                clickedComponent.setBackground(clickedState);
                break;
        }
    }

    private void holdBlinkEffect() {
        if (!animationState) {
            animationState = true;
            new Thread(() -> {
                effect();
                animationState = false;
            }).start();
        }
    }

    private void blinkEffect() {
        if (!animationState) {
            animationState = true;
            new Thread(() -> {
                effect();
                changeColor();
                effect();
                changeColor();
                animationState = false;
            }).start();
        }
    }

    private void changeColor() {
        Color newC = normalState;
        normalState = clickedState;
        clickedState = newC;
    }

    private synchronized void effect() {
        try {
            double r = normalState.getRed();
            double g = normalState.getGreen();
            double b = normalState.getBlue();

            double rM = (clickedState.getRed() - r) / 20;
            double gM = (clickedState.getGreen() - g) / 20;
            double bM = (clickedState.getBlue() - b) / 20;
            for (int i = 0; i < 20; i++) {
                clickedComponent.setBackground(new Color(((int) Math.round(r)), ((int) Math.round(g)), ((int) Math.round(b))));
                Thread.sleep(i > 10 ? 5 : 10);
                r += rM;
                g += gM;
                b += bM;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
