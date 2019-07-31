Java App Engine Google Action Endpoint
======================================

Project template to use a Java App Engine as endpoint
for Google actions. 

## Features

- Google Actions Framework to manage requests and responses
directly from Google or via DialogFlow
- Google Actions Api v2
- DialogFlow end point (v1 and v2 support)
- Account linking Framework implementing implicit flow and
authorization code flow

## Requirements

* Java 7
* [Maven](https://maven.apache.org/download.cgi) (at least 3.3.9)
* [Google Cloud SDK](https://cloud.google.com/sdk/) (aka gcloud)

Initialize the Google Cloud SDK using:

    gcloud init

This skeleton is ready to run.

## Maven

### Run Locally

    mvn appengine:run

### Deploy

    mvn appengine:deploy

### Test Only

    mvn test


## What you need to change in this project template

Class AppConfiguration: change the data for your project, assign
username and password to DialogFlow so each request is authenticated

You can extend the DFWebhookServletV2 to use DialogFlow v2 API, an example is
the DummyDFServletV2.

For account linking you can extend AuthServlet and TokenServlet.
You can see examples like DummyAuthServlet and DummyTokenServlet.

In order to use the OAuth2 for account linking you need to generate
tokens. There are several ways to generate a token. According to
Google docs you can create a json object and the use symmetric
encryption or you can simply generate random numbers. In the latter
case you need to save the information in the datastore using
Objectify.

If you use Objectify you need to implement the method register
in the class OfyHelper.
