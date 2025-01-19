
# **SS Info Plugin**

## **Overview**
The **SS Plugin** is a Minecraft plugin designed to help staff members manage frozen players on the server. When a player is frozen by a staff member, they can use the `/ss` command to open a GUI with information and policies about the screensharing process, including steps for screensharing, reasons for the freeze, and the server’s freeze policy.

## **Features**
- **Freeze GUI**: Displays a GUI with three clickable items when a player is frozen.
  1. **Steps to Screenshare**: Instructions to join Discord, start a screenshare, and download AnyDesk if requested.
  2. **Reasons for Freeze**: Displays the reasons why a player has been frozen (e.g., suspicious movement, alerts, player reports).
  3. **Freeze Policy**: Displays the policy on being frozen, including requirements like not leaving the game, using a Minecraft scanner, and following staff instructions.
- **Prevents Item Removal**: Prevents players from removing items from the GUI during the freeze.
  
## **Installation**

### Prerequisites
- Minecraft server running **Spigot** or **Paper** (version 1.19 or later).
- Java 17 or higher installed.

### Steps to Install
1. Download the latest `.jar` release from the GitHub releases page.
2. Place the `.jar` file into the `plugins/` folder of your Minecraft server.
3. Restart the server or run the `/reload` command to load the plugin.

## **Commands**

### `/ss`
- **Description**: Opens the Screenshare GUI for frozen players.
- **Usage**: `/ss`
- **Permission**: `ss.command`
- **Permission Message**: "You do not have permission to use this command."

## **Configuration**

### **plugin.yml**

The `plugin.yml` is the core configuration file that registers your plugin commands and sets up basic information.

```yaml
commands:
  ss:
    description: Opens the Screenshare GUI for frozen players
    usage: /<command>
    permission: ss.command
    permission-message: You do not have permission to use this command.
```

### **Permission Nodes**
- `ss.command`: Grants permission for the `/ss` command. Assign this permission to staff members or trusted players.

## **Usage**

1. When a player is frozen, they can use the `/ss` command to open the freeze GUI.
2. Inside the GUI, the player can click on the following:
   - **Steps to Screenshare**: View the steps required to start a screenshare session.
   - **Reasons for Freeze**: View the reasons for being frozen (e.g., suspicious behavior, alerts).
   - **Policy**: View the server's policy for being frozen and the actions that must be followed.

## **Contributing**
Feel free to fork this repository and submit pull requests if you'd like to contribute to the development of this plugin! You can also open issues to report bugs or request new features.

### **How to Contribute**:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -am 'Add new feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Open a pull request.

## **License**
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## **Acknowledgments**
- Thanks to the Minecraft community for making it easy to develop plugins.
- Thanks to the Spigot and Paper API documentation for all the helpful resources.

---

### **Explanation of Sections:**
- **Overview**: A brief summary of the plugin’s purpose and features.
- **Features**: Describes the main functionality of the plugin.
- **Installation**: Provides step-by-step instructions on how to install the plugin.
- **Commands**: Describes the available commands and their usage.
- **Configuration**: Shows the plugin.yml configuration file and permissions.
- **Usage**: Explains how to use the plugin in-game.
- **Contributing**: If you want to allow others to contribute, you can include this section. It explains how users can fork, make changes, and submit pull requests.
- **License**: If you have a license, like MIT, you can mention it here.
