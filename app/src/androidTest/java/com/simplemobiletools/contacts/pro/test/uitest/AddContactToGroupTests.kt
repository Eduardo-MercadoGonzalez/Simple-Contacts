package com.simplemobiletools.contacts.pro.uitest

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.simplemobiletools.contacts.pro.activities.MainActivity
import com.simplemobiletools.contacts.pro.robots.addContact
import com.simplemobiletools.contacts.pro.robots.createGroup
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
// @RunWith(AndroidJUnit4::class.java)

class AddContactToGroupTests {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

 //   @get:Rule
 //   val composeTestRule = createComposeRule()
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity  createComposeRule()
    private val testGroupName = "Detectives"


    /**
     * Test Url: https://amedeloitte.sharepoint.com/:x:/r/sites/Project305-Framework_Testing_Automation/Documents/Framework_Testing_Automation
     * Android-Simple Contacts-TCs/TC-6
     * Feature:  Switches
     * Test Case: Check contacts have been added to group.
     * Preconditions: N/A
     */

    @Before
    fun createContactAndGroup(){
        addContact { createContact("Nero", "Wolf", "3121231212") }
        createGroup { clickOnAddGroup() } result { addGroupViewOK() }
        createGroup { createGroup(testGroupName) }
    }


    @Test
    fun groupTest() {
        createGroup { addContactToGroup(testGroupName, "Nero", "Wolf" ) } result {checkContactInGroup(testGroupName, "Nero", "Wolf")}
    }

    @After
    fun groupsRemoveGroup(){
        createGroup { removeGroup(testGroupName) }
        addContact { removeContact("Nero", "Wolf") }
    }
}
