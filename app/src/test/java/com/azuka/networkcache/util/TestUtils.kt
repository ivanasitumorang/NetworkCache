package com.azuka.networkcache.util

import com.azuka.networkcache.base.utils.convertStringToMap
import com.azuka.networkcache.data.local.entity.PostEntity
import com.azuka.networkcache.data.remote.response.PostResponse
import com.azuka.networkcache.domain.model.Post
import com.azuka.networkcache.presentation.PostDataMapper
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.StringWriter


/**
 * Created by ivanaazuka on 27/11/20.
 * Android Engineer
 */

object TestUtils {
    fun getEmptyPost() = emptyList<Post>()

    fun getSearchPosts(query: String): List<Post> {
        return getPostsFromJson().filter {
            it.title.contains(query)
        }
    }

    fun getPostsFromJson(): List<Post> {
        val inputStream =
            javaClass.classLoader?.getResourceAsStream("dummy_posts.json")

        val writer = StringWriter()
        val buffer = CharArray(1024)
        inputStream.use { stream ->
            val reader = BufferedReader(InputStreamReader(stream, "UTF-8"))
            var n: Int
            while (reader.read(buffer).also { n = it } != -1) {
                writer.write(buffer, 0, n)
            }
        }

        val jsonString = writer.toString()

        return jsonString.convertStringToMap<List<PostResponse>>().map {
            PostDataMapper.mapResponseToDomain(it)
        }
    }

    fun getPostResponsesFromJson(): List<PostResponse> {
        val inputStream =
            javaClass.classLoader?.getResourceAsStream("dummy_posts.json")

        val writer = StringWriter()
        val buffer = CharArray(1024)
        inputStream.use { stream ->
            val reader = BufferedReader(InputStreamReader(stream, "UTF-8"))
            var n: Int
            while (reader.read(buffer).also { n = it } != -1) {
                writer.write(buffer, 0, n)
            }
        }

        val jsonString = writer.toString()

        return jsonString.convertStringToMap()
    }

    fun getPostEntities(): List<PostEntity> {
        val inputStream =
            javaClass.classLoader?.getResourceAsStream("dummy_posts.json")

        val writer = StringWriter()
        val buffer = CharArray(1024)
        inputStream.use { stream ->
            val reader = BufferedReader(InputStreamReader(stream, "UTF-8"))
            var n: Int
            while (reader.read(buffer).also { n = it } != -1) {
                writer.write(buffer, 0, n)
            }
        }

        val jsonString = writer.toString()

        return jsonString.convertStringToMap<List<PostResponse>>().map {
            PostDataMapper.mapResponseToEntity(it)
        }
    }
}