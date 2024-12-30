package com.plcoding.bookpedia.book.data.dto

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

object BookWorkDtoSerializer:KSerializer<BookWorkDto> {
    // Here we write which field we`re actually looking for to deserialize
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor(
        serialName = BookWorkDto::class.simpleName!! // or I can write just a name: serialName = "BookWorkDto"
    ) {
        element<String?>("description") // which field we are looking for in Json file
    }

    override fun deserialize(decoder: Decoder): BookWorkDto = decoder.decodeStructure(descriptor) {
        var description: String? = null

        while(true) {
            when(
                // that index does not refer to the actually index of the Json response (like the
                // order of the fields), but to the order that we`ve specified in
                // descriptor: element<String?>("description") - index 0
                // if I had one more element there, like  element<String?>("title"), then the
                // title element will be index 1
                val index = decodeElementIndex(descriptor)
            ) {
                // index == 0, it`s mean we actually decoded this description field which can be
                // now a string or Json object. Inside of 0 -> we put the logic to decode these two
                // cases in here
                0 -> {
                    val jsonDecoder = decoder as? JsonDecoder ?: throw SerializationException(
                        "This decoder only works with JSON."
                    )
                    // decodeJsonElement() could be anything relating to Json
                    // (e.g. JsonObject, string, list)
                    val element = jsonDecoder.decodeJsonElement()
                    description = if(element is JsonObject) {
                        decoder.json.decodeFromJsonElement<DescriptionDto>(
                            element = element,
                            deserializer = DescriptionDto.serializer()
                        ).value
                    } else if(element is JsonPrimitive && element.isString) {
                        element.content // it will be the actual value of the description field
                    } else null
                }
                CompositeDecoder.DECODE_DONE -> break
                else -> throw SerializationException("Unexpected index $index")
            }
        }
        return@decodeStructure BookWorkDto(description)
    }



    // We using this function if we wanna push data to the API. So we take kotlin object and
    // serialize it as Json
    override fun serialize(encoder: Encoder, value: BookWorkDto) = encoder.encodeStructure(
        descriptor
    ) {
        value.description?.let {
            encodeStringElement(descriptor, 0, it)
        }
    }
}