## Requirements - app
1. The app should follow Google Material Design guidelines (Android) or Apple iOS app design guidelines (iOS). **DONE**
2. The app should implement bottom navigation (Tab bar on iOS) with the following tabs. Overview, Education, Work, Skills, Contact.
    1. Overview – should contain your picture and your introduction.  **DONE**
    1. Education – should contain your educational background as a list with necessary details like duration, institution etc.  **DONE**
    1. Work – should contain your work experience with necessary details like employer, durations etc.  **DONE**
    1. Skills – should contain your area of expertise and other relevant skills.  **DONE**
    1. Contact – should contain your contact information and a way to contact you. **MISSING**
3. Your “Overview” should be served as a dynamic json content from a mock api like
https://www.mocky.io/  **DONE**
4. All other data should be served as mock data from json contained in the app.  **DONE**
##### Bonus tasks
5. Write unit tests for critical code areas. **MISSING**
6. Implement offline-first strategy to load the “Overview” and implement a local
database (SQLite, Room or Realm).  **DONE**
7. Android: use an image caching framework **MISSING** and a networking framework **DONE**
8. iOS: Please consider using Alamofire, RxSwift and Realm.
9. Be creative, surprise us with a ‘killer feature’. **It's instant app ready**

## Build and run
1. Open project in Android Studio 
1. In top toolbar menu Run > Run 'instantapp'
1. Connect device create New virtual device
1. Select device and click Ok to run the app.

#### Requires
- Android Studio 3.2 Canary 14+ (to preview Navigation graph got to File > Settings (Android Studio > Preferences on Mac), select the Experimental category in the left pane, check Enable Navigation Editor, and then restart Android Studio.)
- Internet connection
