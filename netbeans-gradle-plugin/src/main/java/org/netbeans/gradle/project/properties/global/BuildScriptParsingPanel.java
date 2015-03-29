package org.netbeans.gradle.project.properties.global;

import java.net.URL;
import org.netbeans.gradle.project.NbStrings;
import org.netbeans.gradle.project.properties.ModelLoadingStrategy;
import org.netbeans.gradle.project.util.NbFileUtils;

@SuppressWarnings("serial")
public class BuildScriptParsingPanel extends javax.swing.JPanel implements GlobalSettingsEditor {
    private static final URL HELP_URL = NbFileUtils.getSafeURL("https://github.com/kelemen/netbeans-gradle-project/wiki/Global-Settings");

    public BuildScriptParsingPanel() {
        initComponents();

        fillModelLoadStrategyCombo();
    }

    private void fillModelLoadStrategyCombo() {
        jModelLoadStrategy.removeAllItems();
        for (ModelLoadingStrategy strategy: ModelLoadingStrategy.values()) {
            jModelLoadStrategy.addItem(new ModelLoadStrategyItem(strategy));
        }
    }

    @Override
    public void updateSettings(GlobalGradleSettings globalSettings) {
        jModelLoadStrategy.setSelectedItem(new ModelLoadStrategyItem(
                globalSettings.modelLoadingStrategy().getValue()));
    }

    @Override
    public void saveSettings(GlobalGradleSettings globalSettings) {
        globalSettings.modelLoadingStrategy().setValue(getModelLoadingStrategy());
    }

    @Override
    public SettingsEditorProperties getProperties() {
        SettingsEditorProperties.Builder result = new SettingsEditorProperties.Builder(this);
        result.setHelpUrl(HELP_URL);

        return result.create();
    }

    private ModelLoadingStrategy getModelLoadingStrategy() {
        ModelLoadStrategyItem selected = (ModelLoadStrategyItem)jModelLoadStrategy.getSelectedItem();
        return selected != null
                ? selected.strategy
                : ModelLoadingStrategy.NEWEST_POSSIBLE;
    }

    private static final class ModelLoadStrategyItem {
        public final ModelLoadingStrategy strategy;
        private final String displayName;

        public ModelLoadStrategyItem(ModelLoadingStrategy strategy) {
            this.strategy = strategy;
            this.displayName = NbStrings.getModelLoadStrategy(strategy);
        }

        @Override
        public int hashCode() {
            return 235 + strategy.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            final ModelLoadStrategyItem other = (ModelLoadStrategyItem)obj;
            return this.strategy == other.strategy;
        }

        @Override
        public String toString() {
            return displayName;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jModelLoadStrategy = new javax.swing.JComboBox<ModelLoadStrategyItem>();
        jModelLoadStrategyLabel = new javax.swing.JLabel();
        jReliableJavaVersionCheck = new javax.swing.JCheckBox();

        org.openide.awt.Mnemonics.setLocalizedText(jModelLoadStrategyLabel, org.openide.util.NbBundle.getMessage(BuildScriptParsingPanel.class, "BuildScriptParsingPanel.jModelLoadStrategyLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jReliableJavaVersionCheck, org.openide.util.NbBundle.getMessage(BuildScriptParsingPanel.class, "BuildScriptParsingPanel.jReliableJavaVersionCheck.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jModelLoadStrategyLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jModelLoadStrategy, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jReliableJavaVersionCheck))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jModelLoadStrategy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jModelLoadStrategyLabel))
                .addGap(18, 18, 18)
                .addComponent(jReliableJavaVersionCheck)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<ModelLoadStrategyItem> jModelLoadStrategy;
    private javax.swing.JLabel jModelLoadStrategyLabel;
    private javax.swing.JCheckBox jReliableJavaVersionCheck;
    // End of variables declaration//GEN-END:variables
}