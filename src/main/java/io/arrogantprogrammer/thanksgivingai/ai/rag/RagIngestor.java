package io.arrogantprogrammer.thanksgivingai.ai.rag;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import io.quarkus.logging.Log;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.nio.file.Path;
import java.util.List;

import static dev.langchain4j.data.document.splitter.DocumentSplitters.recursive;

@ApplicationScoped
public class RagIngestor {

    /**
     * Ingests the documents from the given location into the embedding store.
     *
     * @param ev             the startup event to trigger the ingestion when the application starts
     * @param store          the embedding store the embedding store (PostGreSQL in our case)
     * @param embeddingModel the embedding model to use for the embedding (BGE-Small-EN-Quantized in our case)
     * @param documents      the location of the documents to ingest
     */
    public void ingest(@Observes StartupEvent ev,
                       EmbeddingStore store, EmbeddingModel embeddingModel,
                       @ConfigProperty(name = "quarkus.langchain4j.easy-rag.path") Path documents) {
        store.removeAll(); // cleanup the store to start fresh (just for demo purposes)
        List<Document> list = FileSystemDocumentLoader.loadDocumentsRecursively(documents);
        EmbeddingStoreIngestor ingestor = EmbeddingStoreIngestor.builder()
                .embeddingStore(store)
                .embeddingModel(embeddingModel)
                .documentSplitter(recursive(100, 25))
                .build();
        ingestor.ingest(list);
        Log.debugf("Documents ingested successfully");
    }
}
