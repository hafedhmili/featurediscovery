# Features Extraction Experiment

This read.me aims to help you to prepare the technical environment of the experiment.

## Tool Installation

### Downloading and Installing Eclipse IDE

You’ll need to download and install a fresh version of Eclipse IDE for JAVA developers from the [Eclipse Download Page](https://www.eclipse.org/downloads/).
Download and unzip the file "**_eclipse-workspace-features.zip_**". Open Eclipse on this workspace.

<img width="599" alt="Capture d’écran, le 2021-09-17 à 15 24 46" src="https://user-images.githubusercontent.com/37906695/133843061-c0574389-c2eb-4b8b-8548-1161aff777b9.png">

This workspace contains 4 projects.

### Installing Features Extraction Plugin

Select "Help" from the toolbar menu → "install new software". Select "add" button, then "archive" button. Load the file "**_featuresExtractionPlugin.zip_**".

<img width="510" alt="Capture d’écran, le 2021-09-17 à 15 33 22" src="https://user-images.githubusercontent.com/37906695/133843906-7682ad2c-e13a-4986-8d8f-e2d9e32c4806.png">

Uncheck the option "Group items by category": 

<img width="809" alt="Capture d’écran, le 2021-09-17 à 15 35 30" src="https://user-images.githubusercontent.com/37906695/133844303-bf5176bd-1536-47f7-b6f6-90fe9e85e3be.png">

Follow the instructions until the end of the plugin installation.

## Getting started with Features Extraction Tool

### Adding Plugin Views

Select "Window" from the toolbar menu → Show View → other ... → other. Select Lattice Graph and Lattice nodes. Put the views in this layout:

<img width="1225" alt="Capture d’écran, le 2021-09-17 à 15 45 55" src="https://user-images.githubusercontent.com/37906695/133845202-8fe9371e-c124-454c-8cd6-0fb173d00c9b.png">

### Generating and Visualizing Your First Lattice Graph

To use the feature extraction plugin, click on the funnel icon at the top of the window :

<img width="485" alt="Capture d’écran, le 2021-09-17 à 15 48 07" src="https://user-images.githubusercontent.com/37906695/133845629-ea0d6d2c-b6bd-435d-a07f-0e7d50a80513.png">

Select a project to analyze : 

<img width="421" alt="Capture d’écran, le 2021-09-17 à 16 01 51" src="https://user-images.githubusercontent.com/37906695/133846908-4aa0140c-ae2d-4810-8173-f1879832f52b.png">

Wait until the end of the operation of features extraction. 

The lattice graph will be displayed in the "lattice graph" view. A file with *.ltc extension will be generated at the root of the project.

The .ltc files of the workspace's project are already generated.

<img width="1223" alt="Capture d’écran, le 2021-09-17 à 16 08 36" src="https://user-images.githubusercontent.com/37906695/133847583-0b7a74ef-48af-4b31-9b29-bc5844970a89.png">

### Navigating Accross Lattice Nodes

Click on a lattice node to get information about its extent and intent. This information is displayed in the "lattice node" view
