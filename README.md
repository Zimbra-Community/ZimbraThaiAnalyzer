ThaiAnalyzer
============

Installation
------------

1. Copy Analyzer from `dist/ThaiAnalyzer.jar` file into `/opt/zimbra/lib/ext/ThaiAnalyzer/ThaiAnalyzer.jar`.  You will need to re-start your server.

2. Modify the zimbraTextAnalyzer Account or COS settings of the user or users to point to your new analyzer:

	```
	zmprov ma user1@mydomain.com zimbraTextAnalyzer 	ThaiAnalyzer
	```

3. New messages will be analyzed with the new plugin.  Search strings will be analyzed with the new plugin.




