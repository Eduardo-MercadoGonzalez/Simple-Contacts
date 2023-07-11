package com.simplemobiletools.contacts.pro.uitest

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.simplemobiletools.contacts.pro.activities.MainActivity
import com.simplemobiletools.contacts.pro.robots.createGroup
import org.junit.After
import org.junit.Rule
import org.junit.Test

class GroupListTests {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
    private val testGroupName = "Detectives"


    /**
     * Test Url: https://amedeloitte.sharepoint.com/:x:/r/sites/Project305-Framework_Testing_Automation/Documents/Framework_Testing_Automation
     * Android-Simple Contacts-TCs/TC-3
     * Feature: List (Information Component)
     * Test Case: Check Groups List shows all added groups.
     * Preconditions: N/A
     */

    @Test
    fun groupsClickTest() {
        createGroup { clickOnAddGroup() } result { addGroupViewOK() }
        createGroup { createGroup(testGroupName) } result { checkGroupList(testGroupName)}
    }

    @After
    fun groupsRemoveGroup(){
        createGroup { removeGroup(testGroupName) }
    }
}
