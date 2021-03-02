This repository contains the source code for the various algorithms, the input data used for the experiments, and the output data/results.

The directory sourcecode contains two subdirectories:
- domain-algorithm3: contains the code for: a) building incidence relations for the FCA algorithm, b) the algorithm for building a Galois lattice from the incidence relationship, and c) a bunch of visitors performing the various bits of pieces of the algorithms presented in the paper, including: purging concept extents, pretty printing, identifying candidate features, categorizing the candidate features, and computing the various metrics

- control-algorithms1-3: the various algorithms mentioned in the paper were integrated into Eclipse as eclipse plug-ins. For algorithm 3, implemented last, we used a clean design where we separated the “domain” (in previous directory) from the “control/GUI” (plug-in stuff) included in this directory. However, the design of algorithms 1 and 2 was not as clean, and so the domain logic (extraction of cases of delegation and multiple inheritance) was implemented as methods of the class FeatureExtractionAction, which implements Eclipse’s org.eclipse.ui.IWorkbenchWindowActionDelegate interface. The “void run(IAction action)” method is configured to execute algorithm 3 (all steps, done in sequence), but the logic to implement algorithms 1 and 2 is provided as methods of FeatureExtractionAction. To invoke algorithms 1 or 2, one has to modify the method “void run(IAction action)”.

The directory data contains two subdirectories:
- input projects:
Contains the five software packages tested (FreeMind0.7.1, javawebmail-0.7, JHotDraw5.2, JReversePro, and Lucene1.4)
- output:
Contains the output produced by the different algorithms, one directory per algorithm. For algorithms 1 and 2, the structure is self explanatory. For algorithm 3, we distinguish between the raw output (raw-output), which is produced directly by the method FeatureExtractionAction.run(IAction), and interpreted-output, which provides a more detailed analysis of the AD-HOC nodes for three projects out of five representing the most mature (JHotDraw), the least mature (JReversePro) and “middle of the road” (Freemind). The file for JHotDraw contains more data  where we compare the outputs of the three algorithms

The file “appendices” contains a textual, case by case analysis of the AD-HOC nodes for JHotDraw (appendix A) and JReversePro (appendix B). It contains in a more digestible format some of the data in the spreadsheets found data/output/algorithm3/interpreted-output 
