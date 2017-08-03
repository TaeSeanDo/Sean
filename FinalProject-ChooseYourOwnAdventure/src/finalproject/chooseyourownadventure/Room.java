
package finalproject.chooseyourownadventure;


public class Room {
    String title;
    String[] descriptions = new String[100];
    int descriptionsSize = 0;
    Option[] options = new Option[12];
    int optionsSize = 0;
    
    private class Option {
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
    
    public void addDescription(String description) {
        descriptions[descriptionsSize] = description;
        descriptionsSize++;
    }
    
    public void addOption(String optStr, String tag) {
        Option o = new Option(optStr, tag);
        options[optionsSize] = o;
        optionsSize++;
    }
    
}
