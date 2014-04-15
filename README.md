nutch-typo3-cms
===============

Apache Nutch plugins for TYPO3 CMS

1. Introduction

1.1. What is TYPO3
TYPO3 is an Open Source Content Management System and Framework, well suited for internet, intranet, and extranet applications and websites. Due to its flexible plugin architecture TYPO3 offers a maximum of possibilities. This makes it one of the most popular Open Source CMS worldwide.
TYPO3 is backed by the TYPO3 Association.

1.2. What is Apache Nutch
Apache Nutch is an open source web-search software project. Stemming from Apache Lucene, it now builds on Apache Solr adding web-specifics, such as a crawler, a link-graph database and parsing support handled by Apache Tika for HTML and and array other document formats.
Apache Nutch can run on a single machine, but gains a lot of its strength from running in a Hadoop cluster
The system can be enhanced (eg other document formats can be parsed) using a highly flexible, easily extensible and thoroughly maintained plugin infrastructure.
Apache Nutch is a project of the Apache Software Foundation.

1.3. What is Apache Nutch for TYPO3
Apache Nutch for TYPO3 is a set of Nutch Plug-Ins to enable easy integration of the Nutch crawler with TYPO3 and specifically the Apache Solr for TYPO3 extension.
The plug-ins provide the following features for use with Apache Solr for TYPO3:
Indexing of the access field – Access Rootline
Indexing of the endtime field
Indexing of keywords from meta tags
Indexing of the SiteHash field 
Indexing of the uid field

2. Installation
You should have received an apache-nutch-for-typo3-<version>.tar.gz package containing Apache Nutch 1.5.1 and plugins for integration with Apache Solr for TYPO3. 
Installation should be as easy as simply unpacking the tar.gz file.

3. Configuration
Most of the settings are pre-configured already and should be ok for most scenarios. However, you still need to configure a few things. Open conf/nutch-site.xml
Here you need to set the URL and the API key of your TYPO3 site with the Apache Solr for TYPO3 extension. You can find the API key at the bottom of the Admin Tools → Search backend module.
The properties to change are typo3.baseUrl and typo3.api.key
The sites to index must be added in urls/seed.txt, one per line.

4. Usage 
Use the following command to run Nutch:
bin/nutch crawl urls -solr <Solr URL> -dir crawl -depth <Indexing depth> -topN <Number of pages per level>
The place holders must be replaced by values fitting your environment of course.
-solr points to your Solr server (f.e. Http://localhost:8080/solr/core_en)
-dir dir names the directory to put the crawl in.
-depth depth indicates the link depth from the root page that should be crawled.
-topN N determines the maximum number of pages that will be retrieved at each level up to the depth.
Also, for more parameters see http://wiki.apache.org/nutch/bin/nutch_crawl 

5. Development
The Nutch version used for developing the plugins is Apache Nutch 1.5.1. Version 2.0 has not been tested.
5.1. Development Environment Setup
Check out Apache Nutch (AN) from Apache SVN
Check out Apache Nutch for TYPO3 (ANfT) from dkd SVN
In your IDE link AN into ANfT to get code completion

5.2. Packaging
The Apache Nutch for TYPO3 project checkout provides an Ant build script. On the command line change to the project directory and simply run ant To build a distributable package. The distributable will be build in AnfT/build/dist/.

The Ant build script 
checks out Apache Nutch
patches Nutch with the changes listed below
copies the TYPO3 plug-ins into the checked-out Nutch source directory
compiles Nutch
compiles the TYPO3 plug-ins
packages a distributable tar.gz file

5.3. Changes
The distribution includes the following changes:
NUTCH-585: Allows to exclude certain parts of a HTML page from being indexed. 
	nutch-585-excludeNodes.patch – 2011-09-18

