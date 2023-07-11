package com.simplemobiletools.contacts.pro.uitest

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.simplemobiletools.contacts.pro.activities.MainActivity
import com.simplemobiletools.contacts.pro.utils.AppButton
import com.simplemobiletools.contacts.pro.robots.click
import org.junit.Rule
import org.junit.Test

class BottomNavBarSelectItemTests {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    /**
     * Test Url: https://amedeloitte.sharepoint.com/:x:/r/sites/Project305-Framework_Testing_Automation/Documents/Framework_Testing_Automation
     * Android-Simple Contacts-TCs/TC-13
     * Feature: Navigation Bar
     * Test Case: Check that the main screen switches between mayor contact views when selected on Nav Bar.
     * Preconditions: N/A
     */
    @Test
    fun favoritesClickTest() {
        click { clickOnButton(AppButton.FAVORITES.buttonName) } result { favoritesOK() }
    }

    @Test
    fun contactsClickTest() {
        click { clickOnButton(AppButton.CONTACTS.buttonName) } result { contactsOK() }
    }

    @Test
    fun groupsClickTest() {
        click { clickOnButton(AppButton.GROUPS.buttonName) } result { groupsOK() }
    }

}
