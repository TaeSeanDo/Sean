
package finalproject.chooseyourownadventure;


public class Room {
    String title;
    String[] descriptions = new String[100];
    int descriptionsSize = 0;
    Option[] options = new Option[12];
    int optionsSize = 0;
    
    public class Option {
        String optString;
        String tagString;
        public Option(String optStr, String tag) {
            optString = optStr;
            tagString = tag;
        }
    }
    
    public void setTitle(String name) {
        title = name;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void addDescription(String description) {
        descriptions[descriptionsSize] = description;
        descriptionsSize++;
    }
    
    public String[] getDescriptions() {
        return descriptions;
    }
    
    public int getDescriptionsSize() {
        return descriptionsSize;
    }
    
    public void addOption(String optStr, String tag) {
        Option o = new Option(optStr, tag);
        options[optionsSize] = o;
        optionsSize++;
    }
    
    public Option[] getOptions() {
        return options;
    }
    
    public int getOptionsSize() {
        return optionsSize;
    }
    
}
