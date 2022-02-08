While working on this assignemnt my largest focus was upon scalability, maintainability
as well as extensibility. As can be seen through my architectural choices 
(MVVM, Separate Data Layer/ Network Layers, Retrofit2 implementation)


What architectural decisions did you make and why? Elaborate on strengths and weaknesses.

MVVM architecture

Strengths:
Separation of Views, ViewModels to access data, repository to store data, and a Room/Cloud service 
for accessing data allows for great separation of components in an application.

Weaknesses:
None, this is the best architecture type for a mobile application

Epoxy for Dynamic views

Strengths:
Allows for easy implementation of loading screens
Allows for easy implementation of error screens
Very easy to add new items to a view. Adding new text displays takes nothing more 
than 3 lines of code.


Weaknesses:
I haven’t had enough time to weed out the full weaknesses of Epoxy. At an initial glance however, 
I am worried about creating very visually appealing screens with Epoxy. Its best for dynamic views 
with changing details

Retrofit2

Strengths: Everything
Very Very fast, secure connections, dynamic URLS, very easy to set up and use. Helps separate 
network and domain layers for cleaner development

Weaknesses:
None that come to mind at the moment

Paging

Strengths:
Optimizes loading times for large queries. Saves time and space complexity

Weaknesses:
Utilized an outdated Paging library (Paging2 vs Paging3). Would have to migrate this system to 
avoid using legacy code.


● How did you handle error cases? Eg: botched response, no response, etc.

SimpleResponse data class in order to catch and successful and failed API calls. Checks for failed 
API calls, Valid API calls, as well as null responses/ badly formatted responses. 
Error codes are efficiently handled.



● How did you test the app?

While I should have created unit tests, I used extensive in emulator testing. 
I used a variety of devices to test the application on several screen sizes. 
Additionally turned off the internet during an API call in order to ensure 
application will not crash on failed calls.


● What third party libraries/ external code snippets did you use, if any?

Libraries used:
Retrofit2: creating connection with Rick and Morty API
Moshi: for parsing JSON responses for API calls in Kotlin
Material.io: utilized for Material Cards and TextViewLayouts for Character Details page
ViewModel: For better application architecture
Epoxy: Allows for dynamic view programing. Can stitch elements together in order to add or remove 
fields from a view programmatically
Picasso: Allows for loading URL images within application Views
Paging: Allows for paging which is supported from API responses for Returning Many values. 
Allows for loading to be done as necessary rather than all at once.

Code Snipet:
ViewBindingKotlinModel.kt file from Epoxy GitHub Repo
This is required for Epoxy functionality.


● If you had more time, what would you have done differently?

Implemented Episode viewing within the character page

Moving towards a Single Activity and Fragment architecture

Adding implementation of an episodes section, as well as locations section to the application

Search functionality for characters list

Write Unit Tests for the application
