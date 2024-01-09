## What is FitFork?

The main idea of FitFork is to help people take care of their health in a new way. Most health apps either track your workouts or give you food advice. FitFork does both. It uses the fitness data from your phone or fitness tracker to suggest what food you should eat. This way, it helps you stay healthy by matching your exercise with the right food.

## Requirements

* Android Studio
* Git
* Android build tools v 28+
* A working Android emulator

## Common setup

Clone the repo and install the dependencies.

```bash
git clone https://github.com/shwetha-shivaraju/FitFork.git
```

Open Android Studio and create a new project from the just downloaded source.


## Steps for read-only access

Open gradle.build in Android Studio and run the app on an emulator or directly on a device.

## Steps for Installation and setup:
### Android Installation:
* Visit the [official Android Studio website](https://developer.android.com/studio) and download the appropriate version for your operating system.
* Run the downloaded installer and follow the on-screen instructions.
* Open Android Studio after installation completion.
* Follow the setup wizard to download necessary components and set up the SDK.

### GIT Installation:
* Visit the [Git downloads page](https://git-scm.com/downloads) and download the suitable version for your operating system.
* Run the downloaded installer and follow the installation prompts.
* During installation, configure settings if necessary (such as selecting components or setting the PATH environment).

### Android Build Tools v28+ Installation (Using Android Studio):
* Launch Android Studio and ensure it's properly set up.
* Navigate to Tools > SDK Manager.
* In the SDK Manager, select the "SDK Tools" tab.
* Check the box next to "Android SDK Build-Tools" and select version 28 (or higher if available).
* Click "Apply" to initiate the download and installation process.

### Setting Up a Working Android Emulator:
* Ensure Android Studio is running and properly set up.
* Access AVD Manager (Android Virtual Device Manager):
* Navigate to Tools > AVD Manager.
* Click "Create Virtual Device."
* Choose a device definition (e.g., Pixel, Nexus) and click "Next."
* Select a system image for the device (preferably API level 28 or higher).
* Configure additional settings if needed (such as RAM, storage, etc.).
* Click "Finish" to create the virtual device.
  
### Run the Virtual Device:
* In the AVD Manager, select the created virtual device.
* Click the "Play" button to launch the emulator.
 
### Depedencies with other components
* Authentication component
* Dashboard component

## Components:

### User Interface of the Application:

<img src="https://hkharikrishna62-demo-s3.s3.amazonaws.com/updatedUI1.png" width="200"/> <img src="https://hkharikrishna62-demo-s3.s3.amazonaws.com/updatedUI2.png" width="200"/> <img src="https://hkharikrishna62-demo-s3.s3.amazonaws.com/updatedUI3.png" width="200"/> <img src="https://hkharikrishna62-demo-s3.s3.amazonaws.com/RecipeScreenInitial.png" width="200"/> <img src="https://hkharikrishna62-demo-s3.s3.amazonaws.com/RecipeRefreshedDialougeScreen.png" width="200"/> <img src="https://hkharikrishna62-demo-s3.s3.amazonaws.com/GoalEditScreen.png" width="200"/>

### Authentication Component:
In 'FitFork', the AuthenticationComponent plays a pivotal role in enhancing the user authentication process. It ensures all essential dependencies for authentication are precisely provided where needed, boosting both efficiency and reliability. Functionally, it serves as a critical bridge linking the authentication logic to the UI elements, notably by injecting dependencies like the AuthenticationViewModel into the GoalSelectionFragment. This integration facilitates a seamless user authentication experience coupled with goal setting. The component is expertly implemented using Dagger, a state-of-the-art dependency injection framework, lending to a modular and maintainable app structure. This choice of technology not only simplifies management and replacement of components but also adds to the scalability and flexibility of the app’s architecture, underlining 'FitFork’s commitment to a robust and user-friendly application.

<img src="https://hkharikrishna62-demo-s3.s3.amazonaws.com/updatedUI1.png" width="200"/> <img src="https://hkharikrishna62-demo-s3.s3.amazonaws.com/updatedUI2.png" width="200"/> <img src="https://hkharikrishna62-demo-s3.s3.amazonaws.com/updatedUI3.png" width="200"/>

### Database Component:
In 'FitFork', the Database Design Module is integral to the project's backbone, emphasizing efficient and secure management of user data. Utilizing Room, a part of Android Jetpack, this module expertly handles data related to user fitness metrics and dietary preferences. Its well-structured database schema and advanced data modeling ensure fast data retrieval and robust synchronization with Firebase cloud storage, providing a seamless, secure, and responsive user experience. This module's sophisticated design and implementation reflect 'FitFork's commitment to reliability and user-centric functionality in the health and wellness domain.

### Backend Recipes Component:
In 'FitFork', the Recipes Backend Logic Component plays a crucial role in enriching the user experience with a diverse array of dietary options. This component is responsible for the seamless integration and management of a vast collection of recipes, tailored to align with individual user fitness goals and dietary preferences. It dynamically interfaces with the database to fetch, update, and manage recipe data, ensuring a personalized and varied diet plan for each user. Utilizing advanced algorithms, this component offers recipe recommendations based on user activity levels and health objectives, demonstrating 'FitFork's commitment to a holistic approach to health and wellness. The implementation of this component not only enhances the app's functionality but also underscores its aim to provide a comprehensive and user-centric health management tool.


### Profile Management Component:
FitFork starts by gathering and organising user data to build a comprehensive profile that includes personal information like age, gender, height, weight, and maybe any dietary or health-related preferences. Users can establish individualised exercise objectives, such as bettering their overall health, losing weight, gaining muscle, or improving cardiovascular function. The app bases how it customises recommendations on these objectives. FitFork considers any nutritional requirements or preferences that users may have, including allergies, gluten intolerance, veganism, or vegetarianism. This guarantees that the recommended meals correspond with the user's dietary preferences.

<img src="https://hkharikrishna62-demo-s3.s3.amazonaws.com/updatedUI3.png" width="200"/>

### Data Analysis from health data
In the realm of health data analysis, the process commences by meticulously processing metrics derived from fitness trackers and smartphones. This involves a sophisticated system that employs advanced machine learning algorithms. These algorithms scrutinize vast datasets, discerning intricate patterns within user activity, sleep patterns, and vital signs. Leveraging these discerned insights, the system goes beyond conventional health tracking. It extends its role to that of a virtual nutritionist by recommending personalized recipes. This transformative approach ensures that dietary recommendations align precisely with an individual's health data, fostering optimal well-being and fitness. The amalgamation of technology and personalized nutrition stands as a testament to the potential for leveraging data analysis to revolutionize health management, providing tailored solutions for individuals to thrive in their unique health and wellness journeys.

### Recipe Component:
In the 'FitFork' app, the Nutrition Recommendation Logic is a sophisticated ensemble of components that work synergistically to enhance the user's culinary experience. RecipeListAdapter and RecipeTypeListAdapter are central to this, presenting recipe data in a user-friendly manner and managing the display of recipes through efficient list updates. They achieve this by only modifying changed parts of the recipe list, ensuring a smooth browsing experience, thanks to Android's RecyclerView and the DiffUtil.ItemCallback class. The heart of this system is the RecipeViewModel, which, developed with Kotlin's 'StateFlow' and 'Flow' and constructed via Dagger's dependency injection, handles the dynamic fetching and updating of recipes based on user preferences. Meanwhile, the RecipesFragment enriches the UI by providing an interactive space for recipe display and selection, leveraging data binding for real-time synchronization with the RecipeViewModel. This amalgamation of technical components not only streamlines recipe management but also personalizes the user experience by catering to diverse dietary needs and preferences, embodying 'FitFork’s commitment to delivering a responsive and tailored nutrition guidance system.

<img src="https://hkharikrishna62-demo-s3.s3.amazonaws.com/RecipeScreenInitial.png" width="200"/> <img src="https://hkharikrishna62-demo-s3.s3.amazonaws.com/RecipeRefreshedDialougeScreen.png" width="200"/> <img src="https://hkharikrishna62-demo-s3.s3.amazonaws.com/GoalEditScreen.png" width="200"/>

### Heart Rate and Respiratory Rate Calculation API
This API extracts heart rate and respiratory rate data from sensor readings, providing insights into the user's current physiological state. This information is subsequently used to refine recipe recommendations, considering factors such as energy expenditure and dietary needs.

<img src="https://hkharikrishna62-demo-s3.s3.amazonaws.com/Avinash2.jpeg" width="200"/>


### Recommending Recipe:
<img src="https://hkharikrishna62-demo-s3.s3.amazonaws.com/RecipeRefreshedDialougeScreen.png" width = 200/>


### Testing User Profile Management Specifications:
User profile management control flow encompasses secure registration, profile creation, and account security measures. Intuitive interface interaction facilitates seamless user experience, integrated with health data analysis. This well-orchestrated process is designed to ensure airtight security while maintaining a user-friendly experience. The intuitive interface seamlessly integrates with health data analysis, providing users with a holistic platform. By merging security with user-centric design, the system not only safeguards sensitive information but also enhances the overall user experience. The commitment to a secure, user-friendly, and integrated profile management system underscores the project's dedication to delivering a comprehensive and trustworthy health and wellness solution for users.
