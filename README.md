# NotifyMyProcess

NotifyMyProcess is a simple Java library that allows you to send notifications to a Telegram bot.

You can pass bash commands to the bot, and it will execute them. The output of the command will be displayed in the terminal and the status of the command will be sent to the bot.

## Installation

To install NotifyMyProcess, you can clone the repository and build the project using Gradle.

Make sure to fill in the `API_TOKEN` and `CHAT_ID` fields in the `SendMessages` class with your Telegram bot's API token and chat ID. Information about bots and how to create them can be found [here](https://core.telegram.org/bots/features).

Make sure to build a shadow jar file using the following command:

```bash
gradle shadowJar
```

## Usage

Afer building the project, it is advised to make a alias for the jar file. You can do this by adding the following line to your `.bashrc` file:

```bash
alias notifymyprocess='java -jar /path/to/NotifyMyProcess.jar'
```

After that, you can use the `notifymyprocess` command in your terminal to send notifications to your Telegram bot.

```bash
notifymyprocess Python3 My_very_long_script.py
```

Will send the following message to your Telegram bot:

```
Command 'Python3 My_very_long_script.py' executed successfully. Execution time: XX ms.
```