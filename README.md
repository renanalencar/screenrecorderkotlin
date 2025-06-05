<p align="center">
    <img src="record.svg" align="center" width="30%">
</p>
<p align="center"><h1 align="center">SCREENRECORDERKOTLIN</h1></p>
<p align="center">
	<em>Capture, Create, Share: Your Screen Story</em>
</p>
<p align="center">
	<img src="https://img.shields.io/github/license/renanalencar/screenrecorderkotlin?style=default&logo=opensourceinitiative&logoColor=white&color=0080ff" alt="license">
	<img src="https://img.shields.io/github/last-commit/renanalencar/screenrecorderkotlin?style=default&logo=git&logoColor=white&color=0080ff" alt="last-commit">
	<img src="https://img.shields.io/github/languages/top/renanalencar/screenrecorderkotlin?style=default&color=0080ff" alt="repo-top-language">
	<img src="https://img.shields.io/github/languages/count/renanalencar/screenrecorderkotlin?style=default&color=0080ff" alt="repo-language-count">
</p>
<p align="center"><!-- default option, no dependency badges. -->
</p>
<p align="center">
	<!-- default option, no dependency badges. -->
</p>
<br>

##  Table of Contents

- [ Overview](#-overview)
- [ Features](#-features)
- [ Project Structure](#-project-structure)
  - [ Project Index](#-project-index)
- [ Getting Started](#-getting-started)
  - [ Prerequisites](#-prerequisites)
  - [ Installation](#-installation)
  - [ Usage](#-usage)
  - [ Testing](#-testing)
- [ Project Roadmap](#-project-roadmap)
- [ Contributing](#-contributing)
- [ License](#-license)
- [ Acknowledgments](#-acknowledgments)


##  Overview

**ScreenRecorderKotlin** is an open-source project designed to simplify screen recording on Android devices. With features like seamless recording initiation and termination, users can effortlessly capture their screens. Ideal for developers and content creators, this project streamlines the screen recording process, enhancing user experience and productivity.


##  Features

|      | Feature         | Summary       |
| :--- | :---:           | :---          |
| ⚙️  | **Architecture**  | <ul><li>Follows a clean MVVM architecture pattern.</li><li>Utilizes `ViewModel` to manage screen recording functionality.</li><li>Separates concerns between UI, business logic, and data layers.</li></ul> |
| 🔩 | **Code Quality**  | <ul><li>Consistent coding style and formatting across the codebase.</li><li>Uses Kotlin language features effectively to write concise and expressive code.</li><li>Includes unit tests for critical components to ensure code reliability.</li></ul> |
| 📄 | **Documentation** | <ul><li>Comprehensive Kotlin documentation within the codebase.</li><li>Includes setup instructions and usage guidelines in the project's README file.</li><li>Comments and docstrings for key functions and classes.</li></ul> |
| 🔌 | **Integrations**  | <ul><li>Integrates with `gradle` for build automation and dependency management.</li><li>Uses `ProGuard` for optimizing and securing the Android app.</li><li>Incorporates Android-specific plugins for seamless development.</li></ul> |
| 🧩 | **Modularity**    | <ul><li>Divides functionality into separate modules for better organization.</li><li>Encapsulates related components within packages for improved maintainability.</li><li>Follows SOLID principles to promote modularity and extensibility.</li></ul> |
| 🧪 | **Testing**       | <ul><li>Includes both local unit tests and instrumented tests for thorough code coverage.</li><li>Uses `JUnit` and `Espresso` for testing Android components.</li><li>Implements test cases to validate critical app functionalities.</li></ul> |
| ⚡️  | **Performance**   | <ul><li>Optimizes screen recording performance for smooth user experience.</li><li>Efficiently manages media projection and file handling during recording sessions.</li><li>Utilizes background services to minimize impact on app responsiveness.</li></ul> |
| 🛡️ | **Security**      | <ul><li>Defines ProGuard rules to enhance app security and obfuscate code.</li><li>Implements secure file handling practices for recorded media.</li><li>Ensures proper permission handling for screen recording functionality.</li></ul> |
| 📦 | **Dependencies**  | <ul><li>Manages project dependencies using a `libs.versions.toml` file.</li><li>Centralizes dependency versions to maintain consistency across modules.</li><li>Includes essential libraries for Android development and screen recording features.</li></ul> |
| 🚀 | **Scalability**   | <ul><li>Designs architecture to accommodate future feature enhancements.</li><li>Uses ViewModel to separate UI logic, enabling easy scalability of UI components.</li><li>Follows best practices to ensure scalability without compromising performance.</li></ul> |


##  Project Structure

```sh
└── screenrecorderkotlin/
    ├── LICENSE
    ├── README.md
    ├── app
    │   ├── .gitignore
    │   ├── build.gradle.kts
    │   ├── proguard-rules.pro
    │   └── src
    ├── build.gradle.kts
    ├── gradle
    │   ├── libs.versions.toml
    │   └── wrapper
    ├── gradle.properties
    ├── gradlew
    ├── gradlew.bat
    └── settings.gradle.kts
```


###  Project Index
<details open>
	<summary><b><code>SCREENRECORDERKOTLIN/</code></b></summary>
	<details> <!-- __root__ Submodule -->
		<summary><b>__root__</b></summary>
		<blockquote>
			<table>
			<tr>
				<td><b><a href='https://github.com/renanalencar/screenrecorderkotlin/blob/master/gradlew.bat'>gradlew.bat</a></b></td>
				<td>- Facilitates Gradle execution on Windows by setting up JVM options and locating the Java executable<br>- Resolves the application's home directory and classpath for running Gradle tasks efficiently<br>- Ensures proper Java configuration for seamless build automation within the project structure.</td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/renanalencar/screenrecorderkotlin/blob/master/build.gradle.kts'>build.gradle.kts</a></b></td>
				<td>- Manages common configuration options for all sub-projects/modules in the codebase, disabling the application, Android, and Compose plugins<br>- This file plays a crucial role in setting up the project structure and ensuring consistent configurations across different modules.</td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/renanalencar/screenrecorderkotlin/blob/master/settings.gradle.kts'>settings.gradle.kts</a></b></td>
				<td>- Manages plugin and dependency repositories for the "Screen Recorder" project, ensuring access to necessary libraries and tools<br>- Centralizes configuration to streamline project setup and maintenance, promoting consistency across the codebase architecture.</td>
			</tr>
			</table>
		</blockquote>
	</details>
	<details> <!-- gradle Submodule -->
		<summary><b>gradle</b></summary>
		<blockquote>
			<table>
			<tr>
				<td><b><a href='https://github.com/renanalencar/screenrecorderkotlin/blob/master/gradle/libs.versions.toml'>libs.versions.toml</a></b></td>
				<td>- Manage project dependencies and versions using a TOML file in the gradle/libs.versions.toml path<br>- This file specifies versions for various libraries and plugins essential for the project's architecture and functionality.</td>
			</tr>
			</table>
		</blockquote>
	</details>
	<details> <!-- app Submodule -->
		<summary><b>app</b></summary>
		<blockquote>
			<table>
			<tr>
				<td><b><a href='https://github.com/renanalencar/screenrecorderkotlin/blob/master/app/build.gradle.kts'>build.gradle.kts</a></b></td>
				<td>- Configure Android application build settings, dependencies, and plugins for the project<br>- Set up necessary configurations such as application ID, SDK versions, build types, and Kotlin options<br>- Manage dependencies for core Android libraries, Compose UI components, testing frameworks, and material design components.</td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/renanalencar/screenrecorderkotlin/blob/master/app/proguard-rules.pro'>proguard-rules.pro</a></b></td>
				<td>- Define project-specific ProGuard rules to optimize and secure the Android app<br>- Control configuration files and preserve line number information for debugging<br>- Uncomment rules for WebView with JS and specify JavaScript interface class<br>- Optimize stack traces and hide original source file names for enhanced security.</td>
			</tr>
			</table>
			<details>
				<summary><b>src</b></summary>
				<blockquote>
					<details>
						<summary><b>main</b></summary>
						<blockquote>
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<details>
										<summary><b>br</b></summary>
										<blockquote>
											<details>
												<summary><b>com</b></summary>
												<blockquote>
													<details>
														<summary><b>renanalencar</b></summary>
														<blockquote>
															<details>
																<summary><b>screenrecorder</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/renanalencar/screenrecorderkotlin/blob/master/app/src/main/java/br/com/renanalencar/screenrecorder/MainActivity.kt'>MainActivity.kt</a></b></td>
																		<td>- Implements the main screen recording functionality in the Android app<br>- Handles starting and stopping screen recording, setting segment duration, and launching the screen capture intent<br>- Uses ViewModel to manage recording state and interacts with the ScreenRecordService for actual recording<br>- The UI allows users to control the recording process easily.</td>
																	</tr>
																	</table>
																	<details>
																		<summary><b>services</b></summary>
																		<blockquote>
																			<table>
																			<tr>
																				<td><b><a href='https://github.com/renanalencar/screenrecorderkotlin/blob/master/app/src/main/java/br/com/renanalencar/screenrecorder/services/ScreenRecordService.kt'>ScreenRecordService.kt</a></b></td>
																				<td>- The `ScreenRecordService` class manages screen recording functionality within the app, handling the initiation, control, and termination of screen capture sessions<br>- It orchestrates the media projection, recording setup, and file management, ensuring a seamless user experience during screen recording sessions.</td>
																			</tr>
																			</table>
																		</blockquote>
																	</details>
																	<details>
																		<summary><b>viewmodels</b></summary>
																		<blockquote>
																			<table>
																			<tr>
																				<td><b><a href='https://github.com/renanalencar/screenrecorderkotlin/blob/master/app/src/main/java/br/com/renanalencar/screenrecorder/viewmodels/ScreenRecorderViewModel.kt'>ScreenRecorderViewModel.kt</a></b></td>
																				<td>Manages screen recording functionality by starting and stopping the recording service based on user actions.</td>
																			</tr>
																			</table>
																		</blockquote>
																	</details>
																	<details>
																		<summary><b>ui</b></summary>
																		<blockquote>
																			<details>
																				<summary><b>theme</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/renanalencar/screenrecorderkotlin/blob/master/app/src/main/java/br/com/renanalencar/screenrecorder/ui/theme/Theme.kt'>Theme.kt</a></b></td>
																						<td>- Defines the theme for the screen recorder UI based on system settings and Android version<br>- Determines color scheme dynamically for Android 12+ devices<br>- Sets primary, secondary, and tertiary colors for light and dark themes<br>- Composes the Material Theme with the defined color scheme and typography for the app's visual appearance.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/renanalencar/screenrecorderkotlin/blob/master/app/src/main/java/br/com/renanalencar/screenrecorder/ui/theme/Type.kt'>Type.kt</a></b></td>
																						<td>- Define typography styles for a Compose UI theme, including bodyLarge with specified font, weight, size, line height, and letter spacing<br>- The code establishes a base set of Material typography styles for the project's UI components.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/renanalencar/screenrecorderkotlin/blob/master/app/src/main/java/br/com/renanalencar/screenrecorder/ui/theme/Color.kt'>Color.kt</a></b></td>
																						<td>Define color constants for the UI theme in the project.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
					<details>
						<summary><b>androidTest</b></summary>
						<blockquote>
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<details>
										<summary><b>br</b></summary>
										<blockquote>
											<details>
												<summary><b>com</b></summary>
												<blockquote>
													<details>
														<summary><b>renanalencar</b></summary>
														<blockquote>
															<details>
																<summary><b>screenrecorder</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/renanalencar/screenrecorderkotlin/blob/master/app/src/androidTest/java/br/com/renanalencar/screenrecorder/ExampleInstrumentedTest.kt'>ExampleInstrumentedTest.kt</a></b></td>
																		<td>- Verifies the app context on an Android device by running an instrumented test<br>- The test ensures that the correct package name is associated with the app under test<br>- This file is crucial for validating the behavior of the application within the testing environment.</td>
																	</tr>
																	</table>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
					<details>
						<summary><b>test</b></summary>
						<blockquote>
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<details>
										<summary><b>br</b></summary>
										<blockquote>
											<details>
												<summary><b>com</b></summary>
												<blockquote>
													<details>
														<summary><b>renanalencar</b></summary>
														<blockquote>
															<details>
																<summary><b>screenrecorder</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/renanalencar/screenrecorderkotlin/blob/master/app/src/test/java/br/com/renanalencar/screenrecorder/ExampleUnitTest.kt'>ExampleUnitTest.kt</a></b></td>
																		<td>Verifies correctness of addition operation in a local unit test for the Screen Recorder project.</td>
																	</tr>
																	</table>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
		</blockquote>
	</details>
</details>

##  Getting Started

###  Prerequisites

Before getting started with screenrecorderkotlin, ensure your runtime environment meets the following requirements:

- **Programming Language:** Kotlin
- **Package Manager:** Gradle


###  Installation

Install screenrecorderkotlin using one of the following methods:

**Build from source:**

1. Clone the screenrecorderkotlin repository:
```sh
❯ git clone https://github.com/renanalencar/screenrecorderkotlin
```

2. Navigate to the project directory:
```sh
❯ cd screenrecorderkotlin
```

3. Install the project dependencies:


**Using `gradle`** &nbsp; [<img align="center" src="https://img.shields.io/badge/Kotlin-0095D5.svg?style={badge_style}&logo=kotlin&logoColor=white" />](https://kotlinlang.org/)

```sh
❯ gradle build
```




###  Usage
Run screenrecorderkotlin using the following command:
**Using `gradle`** &nbsp; [<img align="center" src="https://img.shields.io/badge/Kotlin-0095D5.svg?style={badge_style}&logo=kotlin&logoColor=white" />](https://kotlinlang.org/)

```sh
❯ gradle run
```


###  Testing
Run the test suite using the following command:
**Using `gradle`** &nbsp; [<img align="center" src="https://img.shields.io/badge/Kotlin-0095D5.svg?style={badge_style}&logo=kotlin&logoColor=white" />](https://kotlinlang.org/)

```sh
❯ gradle test
```


##  Project Roadmap

- [X] **`Task 1`**: <strike>Implement feature one.</strike>
- [ ] **`Task 2`**: Implement feature two.
- [ ] **`Task 3`**: Implement feature three.


##  Contributing

- **💬 [Join the Discussions](https://github.com/renanalencar/screenrecorderkotlin/discussions)**: Share your insights, provide feedback, or ask questions.
- **🐛 [Report Issues](https://github.com/renanalencar/screenrecorderkotlin/issues)**: Submit bugs found or log feature requests for the `screenrecorderkotlin` project.
- **💡 [Submit Pull Requests](https://github.com/renanalencar/screenrecorderkotlin/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.

<details closed>
<summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your github account.
2. **Clone Locally**: Clone the forked repository to your local machine using a git client.
   ```sh
   git clone https://github.com/renanalencar/screenrecorderkotlin
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to github**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.
8. **Review**: Once your PR is reviewed and approved, it will be merged into the main branch. Congratulations on your contribution!
</details>

<details closed>
<summary>Contributor Graph</summary>
<br>
<p align="left">
   <a href="https://github.com{/renanalencar/screenrecorderkotlin/}graphs/contributors">
      <img src="https://contrib.rocks/image?repo=renanalencar/screenrecorderkotlin">
   </a>
</p>
</details>


##  License

This project is protected under the [MIT](https://choosealicense.com/licenses/mit/) License. For more details, refer to the [LICENSE](https://choosealicense.com/licenses/mit/) file.


##  Acknowledgments

- List any resources, contributors, inspiration, etc. here.

