package com.simplemobiletools.contacts.pro.uitest

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.simplemobiletools.contacts.pro.activities.MainActivity
import com.simplemobiletools.contacts.pro.robots.addContact
import org.junit.Rule
import org.junit.Test

class PressAddButtonTests {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    /**
     * Test Url: https://amedeloitte.sharepoint.com/:x:/r/sites/Project305-Framework_Testing_Automation/Documents/Framework_Testing_Automation
     * Android-Simple Contacts-TCs/TC-1
     * Feature: press button
     * Test Case: Check Add Contact screen is displayed when Add button is pressed.
     * Preconditions: N/A
     */
    @Test
    fun clickAddButtonTest() {
        addContact { clickOnAdd() } result { addContactViewOK() }
    }
}
